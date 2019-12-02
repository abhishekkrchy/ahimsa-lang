package ahimsa.parmo.dharmah.utils;

import ahimsa.parmo.dharmah.AhimsaError;
import io.vavr.collection.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Input {
    public static List<List<String>> readFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> strings = List.ofAll(reader.lines());
            return strings.map(List::of);
        } catch (IOException e) {
            throw new AhimsaError(e);
        }
    }
}
