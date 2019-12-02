package ahimsa.parmo.dharmah;

import ahimsa.parmo.dharmah.listener.AhimsaCmdListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Application {
    public static void main(String[] args) {
        ANTLRInputStream input = new ANTLRInputStream(String.join(" ", args));
        AhimsaLexer lexer = new AhimsaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AhimsaParser parser = new AhimsaParser(tokens);
        ParseTree tree = parser.command();

        ParseTreeWalker walker = new ParseTreeWalker();
        AhimsaCmdListener cmdListener = new AhimsaCmdListener();
        walker.walk(cmdListener, tree);
        cmdListener.evaluate();
    }
}
