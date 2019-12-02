package ahimsa.parmo.dharmah.eval.impl;

import ahimsa.parmo.dharmah.AhimsaError;
import ahimsa.parmo.dharmah.eval.Eval;
import io.vavr.collection.List;

public class SplitBy implements Eval {

    private final String splitWord;

    public SplitBy(String splitWord) {
        this.splitWord = splitWord;
    }

    @Override
    public List<List<String>> eval(List<List<String>> data) {
        return data.map(this::splitByVar);
    }

    private List<String> splitByVar(List<String> list) {
        // TODO : maybe allow more
        if (list.size() != 1) {
            throw new AhimsaError("How to split already split words?");
        }
        return List.of(list.get(0).split(splitWord));
    }
}
