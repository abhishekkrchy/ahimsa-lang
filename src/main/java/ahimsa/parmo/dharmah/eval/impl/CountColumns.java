package ahimsa.parmo.dharmah.eval.impl;

import ahimsa.parmo.dharmah.eval.Eval;
import ahimsa.parmo.dharmah.utils.Output;
import io.vavr.collection.List;
import io.vavr.collection.Traversable;

public class CountColumns implements Eval {
    @Override
    public List<List<String>> eval(List<List<String>> data) {
        Output.out(data.map(Traversable::size).max().getOrElse(0));
        return List.empty();
    }
}
