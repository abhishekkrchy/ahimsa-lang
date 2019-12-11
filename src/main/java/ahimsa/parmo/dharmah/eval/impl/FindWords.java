package ahimsa.parmo.dharmah.eval.impl;

import ahimsa.parmo.dharmah.eval.Eval;
import io.vavr.collection.List;

public class FindWords implements Eval {

    private final List<String> wordsToFind;

    public FindWords(List<String> wordsToFind){
        this.wordsToFind = wordsToFind;
    }

    @Override
    public List<List<String>> eval(List<List<String>> data) {
        return data.filter(this::containsAny);
    }

    private boolean containsAny(List<String> data){
        for(String word: wordsToFind){
            for (String sourceStr : data){
                if (sourceStr.contains(word)){
                    return true;
                }
            }
        }
        return false;
    }
}
