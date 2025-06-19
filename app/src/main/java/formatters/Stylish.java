package formatters;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Stylish {
    public static String getFormat(LinkedHashMap<String, HashMap<String, Object>> data) {
        StringJoiner result = new StringJoiner("\n");
        result.add("{");
        for (var key : data.keySet()) {
            var value = data.get(key);
            if (value.get("state").equals("added")) {
                result.add("  + " + key + ": " + value.get("value"));
            } else if (value.get("state").equals("removed")) {
                result.add("  - " + key + ": " + value.get("value"));
            } else if (value.get("state").equals("noChange")) {
                result.add("    " + key + ": " + value.get("value"));
            } else {
                result.add("  - " + key + ": " + value.get("oldValue"));
                result.add("  + " + key + ": " + value.get("newValue"));
            }
        }
        return result.add("}").toString();
    }
}
