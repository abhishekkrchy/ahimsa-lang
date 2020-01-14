package ahimsa.parmo.dharmah.eval.impl;

import ahimsa.parmo.dharmah.eval.Eval;
import io.vavr.collection.List;

public class FindWords implements Eval {

    private final String wordToFind;

    public FindWords(String wordToFind) {
        this.wordToFind = wordToFind;
    }

    @Override
    public List<List<String>> eval(List<List<String>> data) {
        return data.filter(this::containsAny);
    }

    private boolean containsAny(List<String> data) {
        for (String sourceStr : data) {
            if (sourceStr.contains(wordToFind)) {
                return true;
            }
        }
        return false;
    }
}
