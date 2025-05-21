package hexlet.code;

import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Differ {
    public static String generate(Map<String, String> firstMapOfJson, Map<String, String> secondMapOfJson) {
        var setOfKeys = new HashSet<String>();
        setOfKeys.addAll(firstMapOfJson.keySet());
        setOfKeys.addAll(secondMapOfJson.keySet());
        List<String> sortedSetOfKeys = new ArrayList<>(setOfKeys);
        Collections.sort(sortedSetOfKeys);

        StringBuilder result = new StringBuilder();
        for (var key : sortedSetOfKeys) {
            var result1 = firstMapOfJson.get(key);
            var result2 = secondMapOfJson.get(key);
            if (result1 == null) {
                result.append("+ ").append(key).append(": ").append(result2).append("\n");
            } else if (result2 == null) {
                result.append("- ").append(key).append(": ").append(result1).append("\n");
            } else if (result1.equals(result2)) {
                result.append(key).append(": ").append(result1).append("\n");
            } else {
                result.append("- ").append(key).append(": ")
                        .append(result1).append("\n")
                        .append("+ ").append(key).append(": ")
                        .append(result2).append("\n");
            }
        }

        return result.toString();
    }
}
