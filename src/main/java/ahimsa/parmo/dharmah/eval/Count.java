package ahimsa.parmo.dharmah.eval;

import io.vavr.collection.List;

public class Count implements Eval {

    @Override
    public List<List<String>> eval(List<List<String>> data) {
        Output.out(data.size());
        return List.empty();
    }
}
