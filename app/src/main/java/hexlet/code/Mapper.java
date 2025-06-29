package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Mapper {
    public static Map<String, LinkedHashMap<String, Object>> getDiff(Map<String, Object> firstMapOfData,
                                                                     Map<String, Object> secondMapOfData) {
        var setOfKeys = new HashSet<String>();
        setOfKeys.addAll(firstMapOfData.keySet());
        setOfKeys.addAll(secondMapOfData.keySet());
        List<String> sortedSetOfKeys = new ArrayList<>(setOfKeys);
        Collections.sort(sortedSetOfKeys);

        LinkedHashMap<String, LinkedHashMap<String, Object>> result = new LinkedHashMap<>();
        for (var key : sortedSetOfKeys) {
            var result1 = firstMapOfData.getOrDefault(key, "absent");
            var result2 = secondMapOfData.getOrDefault(key, "absent");
            if (String.valueOf(result1).equals("absent")) { // added
                var value = new LinkedHashMap<String, Object>();
                value.put("state", "added");
                value.put("value", result2);
                result.put(key, value);
            } else if (String.valueOf(result2).equals("absent")) { // removed
                var value = new LinkedHashMap<String, Object>();
                value.put("state", "removed");
                value.put("value", result1);
                result.put(key, value);
            } else if (String.valueOf(result1).equals(String.valueOf(result2))) { // no change
                var value = new LinkedHashMap<String, Object>();
                value.put("state", "noChange");
                value.put("value", result1);
                result.put(key, value);
            } else { // updated
                var value = new LinkedHashMap<String, Object>();
                value.put("state", "updated");
                value.put("oldValue", result1);
                value.put("newValue", result2);
                result.put(key, value);
            }
        }
        return result;
    }
}
