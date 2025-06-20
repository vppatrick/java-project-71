package formatters;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public final class Stylish {
    private static final String STATE = "state";
    private static final String VALUE = "value";
    private Stylish() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(Map<String, LinkedHashMap<String, Object>> data) {
        StringJoiner result = new StringJoiner("\n");
        result.add("{");
        for (var entry : data.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (value.get(STATE).equals("added")) {
                result.add("  + " + key + ": " + value.get(VALUE));
            } else if (value.get(STATE).equals("removed")) {
                result.add("  - " + key + ": " + value.get(VALUE));
            } else if (value.get(STATE).equals("noChange")) {
                result.add("    " + key + ": " + value.get(VALUE));
            } else {
                result.add("  - " + key + ": " + value.get("oldValue"));
                result.add("  + " + key + ": " + value.get("newValue"));
            }
        }
        return result.add("}").toString();
    }
}
