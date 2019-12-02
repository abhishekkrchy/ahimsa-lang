package ahimsa.parmo.dharmah.eval.pipe;

import ahimsa.parmo.dharmah.eval.Eval;
import ahimsa.parmo.dharmah.utils.Input;
import ahimsa.parmo.dharmah.utils.Output;
import io.vavr.collection.List;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalPipe {

    private final Deque<Eval> deque = new ArrayDeque<>();
    private final String fileName;

    EvalPipe(String fileName) {
        this.fileName = fileName;
    }

    void addEvalStep(Eval eval) {
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
}
