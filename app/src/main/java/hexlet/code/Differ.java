package hexlet.code;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Differ {
    public static String generate(Map<String, Object> firstMapOfData,
                                  Map<String, Object> secondMapOfData, String format) {
        var setOfKeys = new HashSet<String>();
        setOfKeys.addAll(firstMapOfData.keySet());
        setOfKeys.addAll(secondMapOfData.keySet());
        List<String> sortedSetOfKeys = new ArrayList<>(setOfKeys);
        Collections.sort(sortedSetOfKeys);

        LinkedHashMap<String, HashMap<String, Object>> result = new LinkedHashMap<>();
        for (var key : sortedSetOfKeys) {
            var result1 = firstMapOfData.getOrDefault(key, "absent");
            var result2 = secondMapOfData.getOrDefault(key, "absent");
            if (String.valueOf(result1).equals("absent")) { // added
                result.put(key, new HashMap<String, Object>() {{
                        put("state", "added");
                        put("value", result2);
                    }});
            } else if (String.valueOf(result2).equals("absent")) { // removed
                result.put(key, new HashMap<String, Object>() {{
                        put("state", "removed");
                        put("value", result1);
                    }});
            } else if (String.valueOf(result1).equals(String.valueOf(result2))) { // no change
                result.put(key, new HashMap<String, Object>() {{
                        put("state", "noChange");
                        put("value", result1);
                    }});
            } else { // updated
                result.put(key, new HashMap<String, Object>() {{
                        put("state", "updated");
                        put("oldValue", result1);
                        put("newValue", result2);
                    }});
            }
        }
        return Formatter.getData(result, format);
    }
}
