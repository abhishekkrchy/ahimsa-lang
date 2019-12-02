package ahimsa.parmo.dharmah.eval.impl;

import ahimsa.parmo.dharmah.eval.Eval;
import io.vavr.collection.List;

public class Replace implements Eval {

    private final String replaced;
    private final String replacement;

    public Replace(String replaced, String replacement) {
        this.replaced = replaced;
        this.replacement = replacement;
    }

    @Override
    public List<List<String>> eval(List<List<String>> data) {
        return data.map(this::replaceAll);
    }

    private List<String> replaceAll(List<String> line) {
        return line.map(word -> word.replaceAll(replaced, replacement));
    }
}
