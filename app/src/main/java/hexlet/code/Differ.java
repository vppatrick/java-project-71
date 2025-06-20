package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Differ {
    private static final String ABSENT = "absent";
    private static final String STATE = "state";
    private static final String VALUE = "value";
    public static String generate(String filePath1, String filePath2, String format) {
        Map<String, Object> firstMapOfData;
        try {
            firstMapOfData = Parser.getData(filePath1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Map<String, Object> secondMapOfData;
        try {
            secondMapOfData = Parser.getData(filePath2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        var setOfKeys = new HashSet<String>();
        setOfKeys.addAll(firstMapOfData.keySet());
        setOfKeys.addAll(secondMapOfData.keySet());
        List<String> sortedSetOfKeys = new ArrayList<>(setOfKeys);
        Collections.sort(sortedSetOfKeys);

        LinkedHashMap<String, LinkedHashMap<String, Object>> result = new LinkedHashMap<>();
        for (var key : sortedSetOfKeys) {
            var result1 = firstMapOfData.getOrDefault(key, ABSENT);
            var result2 = secondMapOfData.getOrDefault(key, ABSENT);
            if (String.valueOf(result1).equals(ABSENT)) { // added
                var value = new LinkedHashMap<String, Object>();
                value.put(STATE, "added");
                value.put(VALUE, result2);
                result.put(key, value);
            } else if (String.valueOf(result2).equals(ABSENT)) { // removed
                var value = new LinkedHashMap<String, Object>();
                value.put(STATE, "removed");
                value.put(VALUE, result1);
                result.put(key, value);
            } else if (String.valueOf(result1).equals(String.valueOf(result2))) { // no change
                var value = new LinkedHashMap<String, Object>();
                value.put(STATE, "noChange");
                value.put(VALUE, result1);
                result.put(key, value);
            } else { // updated
                var value = new LinkedHashMap<String, Object>();
                value.put(STATE, "updated");
                value.put("oldValue", result1);
                value.put("newValue", result2);
                result.put(key, value);
            }
        }
        return Formatter.getData(result, format);
    }
}
