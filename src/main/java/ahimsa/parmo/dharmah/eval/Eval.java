package ahimsa.parmo.dharmah.eval;

import io.vavr.collection.List;

public interface Eval {
    List<List<String>> eval(List<List<String>> data);
}
