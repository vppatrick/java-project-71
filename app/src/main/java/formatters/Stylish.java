package formatters;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public final class Stylish {
    private Stylish() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(Map<String, LinkedHashMap<String, Object>> data) {
        StringJoiner result = new StringJoiner("\n");
        result.add("{");
        for (var entry : data.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
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
