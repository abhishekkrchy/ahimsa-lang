package ahimsa.parmo.dharmah;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        ANTLRInputStream input = new ANTLRInputStream(String.join(" ", args));
//    AhimsaLexer lexer = new AhimsaLexer(input);
//    CommonTokenStream tokens = new CommonTokenStream(lexer);
//    AhimsaParser parser = new AhimsaParser(tokens);
//    ParseTree tree = parser.command();
//    AhimsaEvaluator visitor = new AhimsaEvaluator();
//    visitor.visit(tree);

        AhimsaLexer lexer = new AhimsaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AhimsaParser parser = new AhimsaParser(tokens);
        ParseTree tree = parser.command(); // parse

        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        AhimsaCmdListener extractor = new AhimsaCmdListener(parser);
        walker.walk(extractor, tree);
    }
}
