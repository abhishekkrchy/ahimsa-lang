package ahimsa.parmo.dharmah.eval;

import io.vavr.collection.List;

public class TakeColumns implements Eval {

    private final List<String> columns;

    public TakeColumns(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public List<List<String>> eval(List<List<String>> data) {
        return data.map(this::filterColumns);
    }

    private List<String> filterColumns(List<String> data) {
        String[] filtered = new String[columns.size()];
        int i = 0;
        for (int idx : columns.map(Integer::parseInt)) {
            filtered[i++] = data.get(idx - 1);
        }
        return List.of(filtered);
    }
}
