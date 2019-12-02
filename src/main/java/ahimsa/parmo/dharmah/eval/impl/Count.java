package ahimsa.parmo.dharmah.eval.impl;

import ahimsa.parmo.dharmah.eval.Eval;
import ahimsa.parmo.dharmah.utils.Output;
import io.vavr.collection.List;

public class Count implements Eval {

    @Override
    public List<List<String>> eval(List<List<String>> data) {
        Output.out(data.size());
        return List.empty();
    }
}
