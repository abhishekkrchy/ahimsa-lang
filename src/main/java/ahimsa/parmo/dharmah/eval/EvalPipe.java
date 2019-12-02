package ahimsa.parmo.dharmah.eval;

import io.vavr.collection.List;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalPipe {

    private final Deque<Eval> deque = new ArrayDeque<>();
    private final String fileName;

    private EvalPipe(String fileName) {
        this.fileName = fileName;
    }

    private void addEvalStep(Eval eval) {
        deque.add(eval);
    }

    private Eval nextStep() {
        return deque.removeLast();
    }

    public void eval() {

        if (deque.isEmpty()) {
            return;
        }

        List<List<String>> evaluated = Input.readFile(fileName);

        while (!deque.isEmpty() && !evaluated.isEmpty()) {
            evaluated = nextStep().eval(evaluated);
        }

        Output.out(evaluated);
    }

    public static EvalPipeBuilder builder(String fileName) {
        return new EvalPipeBuilder(fileName);
    }

    public static class EvalPipeBuilder {

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
}
