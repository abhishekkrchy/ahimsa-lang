package ahimsa.parmo.dharmah;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AhimsaCmdListener extends AhimsaBaseListener {

    private final AhimsaParser parser;

    private List<List<String>> contents;

    public AhimsaCmdListener(AhimsaParser parser) {
        this.parser = parser;
    }

    @Override
    public void enterCommand(AhimsaParser.CommandContext ctx) {
        String fileName = ctx.FILENAME().getText();
        System.out.println("filename : "+ctx.FILENAME().getText());
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            contents = reader.lines().map(Collections::singletonList).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("File read failed.");
        }
    }

    @Override
    public void exitCommand(AhimsaParser.CommandContext ctx) {
        if (contents == null) {
            return;
        }
        contents.forEach(wordList -> System.out.println(String.join(" ", wordList)));
    }


    @Override
    public void enterCount(AhimsaParser.CountContext ctx) {
        System.out.println(contents.size());
        contents = null;
    }

    @Override
    public void exitCount(AhimsaParser.CountContext ctx) {

    }

    @Override
    public void enterRipApartBy(AhimsaParser.RipApartByContext ctx) {
        String splitByVar = ctx.ARGS().getText();
        contents = contents.stream().map(line -> splitByVar(line, splitByVar)).collect(Collectors.toList());
    }

    private List<String> splitByVar(List<String> list, String splitByVar) {
        if (list.size() != 1) {
            throw new RuntimeException("How to split already split words?");
        }
        return Arrays.asList(list.get(0).split(splitByVar));
    }

    @Override
    public void exitRipApartBy(AhimsaParser.RipApartByContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
