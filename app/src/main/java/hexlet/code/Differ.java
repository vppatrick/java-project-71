package hexlet.code;

import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Differ {
    public static String generate(Map<String, String> firstMapOfJson, Map<String, String> secondMapOfJson) {
        var setOfKeys = new HashSet<String>();
        setOfKeys.addAll(firstMapOfJson.keySet());
        setOfKeys.addAll(secondMapOfJson.keySet());
        List<String> sortedSetOfKeys = new ArrayList<>(setOfKeys);
        Collections.sort(sortedSetOfKeys);

        StringJoiner result = new StringJoiner("\n");
        result.add("{");
        for (var key : sortedSetOfKeys) {
            var result1 = firstMapOfJson.get(key);
            var result2 = secondMapOfJson.get(key);
            if (result1 == null) {
                result.add("  + " + key + ": " + result2);
            } else if (result2 == null) {
                result.add("  - " + key + ": " + result1);
            } else if (result1.equals(result2)) {
                result.add("    " + key + ": " + result1);
            } else {
                result.add("  - " + key + ": " + result1);
                result.add("  + " + key + ": " + result2);
            }
        }
        return result.add("}").toString();
    }
}
