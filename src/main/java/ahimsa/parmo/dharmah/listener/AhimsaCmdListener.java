package ahimsa.parmo.dharmah.listener;

import ahimsa.parmo.dharmah.AhimsaBaseListener;
import ahimsa.parmo.dharmah.AhimsaParser;
import ahimsa.parmo.dharmah.eval.impl.Count;
import ahimsa.parmo.dharmah.eval.impl.Replace;
import ahimsa.parmo.dharmah.eval.impl.SplitBy;
import ahimsa.parmo.dharmah.eval.impl.TakeColumns;
import ahimsa.parmo.dharmah.eval.pipe.EvalPipe;
import ahimsa.parmo.dharmah.eval.pipe.EvalPipeBuilder;
import io.vavr.collection.List;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AhimsaCmdListener extends AhimsaBaseListener {

    private EvalPipeBuilder evalPipeBuilder;

    @Override
    public void enterCommand(AhimsaParser.CommandContext ctx) {
        evalPipeBuilder = new EvalPipeBuilder(ctx.FILENAME().getText());
    }

    @Override
    public void enterCount(AhimsaParser.CountContext ctx) {
        evalPipeBuilder.after(new Count());
    }

    @Override
    public void enterSplitBy(AhimsaParser.SplitByContext ctx) {
        evalPipeBuilder.after(new SplitBy(ctx.WORD().getText()));
    }

    @Override
    public void enterReplace(AhimsaParser.ReplaceContext ctx) {
        evalPipeBuilder.after(new Replace(ctx.WORD(0).getText(), ctx.WORD(1).getText()));
    }

    @Override
    public void enterTakeColumns(AhimsaParser.TakeColumnsContext ctx) {
        evalPipeBuilder.after(new TakeColumns(List.ofAll(ctx.WORD()).map(TerminalNode::getText)));
    }

    public void evaluate() {
        evalPipeBuilder.build().eval();
    }
}
