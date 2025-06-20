package formatters;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public final class Plain {
    private static final String PROPERTY = "Property '";
    private static final String STATE = "state";
    private Plain() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(Map<String, LinkedHashMap<String, Object>> data) {
        StringJoiner result = new StringJoiner("\n");
        for (var entry : data.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (value.get(STATE).equals("added")) {
                result.add(PROPERTY + key + "' was added with value: "
                        + castingToType(value.get("value")));
            } else if (value.get(STATE).equals("removed")) {
                result.add(PROPERTY + key + "' was removed");
            } else if (value.get(STATE).equals("updated")) {
                result.add(PROPERTY + key + "' was updated. From "
                        + castingToType(value.get("oldValue")) + " to "
                        + castingToType(value.get("newValue")));
            }
        }
        return result.toString();
    }

    private static String castingToType(Object value) {
        if (value instanceof Number || value instanceof Boolean || value == null) {
            return String.valueOf(value);
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return "[complex value]";
        }
    }
}
