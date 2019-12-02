package ahimsa.parmo.dharmah.eval.pipe;

import ahimsa.parmo.dharmah.eval.Eval;

public class EvalPipeBuilder {

    private EvalPipe evalPipe;

    public EvalPipeBuilder(String fileName) {
        evalPipe = new EvalPipe(fileName);
    }

    public EvalPipeBuilder after(Eval eval) {
        evalPipe.addEvalStep(eval);
        return this;
    }

    public EvalPipe build() {
        return evalPipe;
    }
}