package formatters;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Plain {
    public static String getFormat(LinkedHashMap<String, LinkedHashMap<String, Object>> data) {
        StringJoiner result = new StringJoiner("\n");
        for (var key : data.keySet()) {
            var value = data.get(key);
            if (value.get("state").equals("added")) {
                result.add("Property '" + key + "' was added with value: "
                        + castingToType(value.get("value")));
            } else if (value.get("state").equals("removed")) {
                result.add("Property '" + key + "' was removed");
            } else if (value.get("state").equals("updated")) {
                result.add("Property '" + key + "' was updated. From "
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
