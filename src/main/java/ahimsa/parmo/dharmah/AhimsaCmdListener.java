package ahimsa.parmo.dharmah;

import io.vavr.collection.List;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AhimsaCmdListener extends AhimsaBaseListener {

    private final AhimsaParser parser;

    private List<List<String>> contents;

    public AhimsaCmdListener(AhimsaParser parser) {
        this.parser = parser;
    }

    @Override
    public void enterCommand(AhimsaParser.CommandContext ctx) {
        String fileName = ctx.FILENAME().getText();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> strings = List.ofAll(reader.lines());
            contents = strings.map(List::of);
        } catch (IOException e) {
            throw new AhimsaError(e);
        }
    }

    @Override
    public void exitCommand(AhimsaParser.CommandContext ctx) {
        if (contents != null) {
            contents.forEach(wordList -> System.out.println(String.join(" ", wordList)));
        }
    }


    @Override
    public void enterCount(AhimsaParser.CountContext ctx) {
        System.out.println(contents.size());
        contents = null;
    }

    @Override
    public void enterSplitBy(AhimsaParser.SplitByContext ctx) {
        contents = contents.map(line -> splitByVar(line, ctx.WORD().getText()));
    }

    private List<String> splitByVar(List<String> list, String splitByVar) {
        if (list.size() != 1) {
            throw new AhimsaError("How to split already split words?");
        }
        return List.of(list.get(0).split(splitByVar));
    }

    @Override
    public void enterReplace(AhimsaParser.ReplaceContext ctx) {
        contents = contents.map(line -> replaceAll(line, ctx.WORD(0).getText(), ctx.WORD(1).getText()));
    }

    private List<String> replaceAll(List<String> line, String replaced, String replacement) {
        return line.map(word -> word.replaceAll(replaced, replacement));
    }

    @Override
    public void enterTakeColumns(AhimsaParser.TakeColumnsContext ctx) {
        List<Integer> columns = List.ofAll(ctx.WORD()).map(TerminalNode::getText).map(Integer::parseInt);
        contents = contents.map(line -> filterColumns(line,columns));

    }

    private List<String> filterColumns(List<String> data, List<Integer> columns){
        String[] filtered = new String[columns.size()];
        int i=0;
        for (int idx:columns){
            filtered[i++] = data.get(idx-1);
        }
        return List.of(filtered);
    }
}
