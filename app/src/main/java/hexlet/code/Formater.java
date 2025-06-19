package hexlet.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Formater {
    public static String getData(LinkedHashMap<String, HashMap<String, String>> data, String format) {
        if (format.equals("stylish")) {
            return stylishFormat(data);
        } else {
            return "invalid format";
        }
    }
    private static String stylishFormat(LinkedHashMap<String, HashMap<String, String>> data) {
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
