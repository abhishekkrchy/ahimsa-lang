package ahimsa.parmo.dharmah.utils;

import io.vavr.collection.List;

public class Output {

    public static void out(List<List<String>> data) {
        if (!data.isEmpty()) {
            data.forEach(wordList -> System.out.println(String.join(" ", wordList)));
        }
    }

    public static void out(int data) {
        System.out.println(data);
    }

}
