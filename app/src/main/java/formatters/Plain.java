package formatters;

import hexlet.code.DiffDTO;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public final class Plain {
    private Plain() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(List<DiffDTO> diffs) {
        StringJoiner result = new StringJoiner("\n");

        for (var diff : diffs) {
            switch (diff.getState()) {
                case "added" -> result.add("Property '" + diff.getName() + "' was added with value: "
                        + castingToType(diff.getValue()));
                case "removed" -> result.add("Property '" + diff.getName() + "' was removed");
                case "updated" -> result.add("Property '" + diff.getName() + "' was updated. From "
                        + castingToType(diff.getOldValue()) + " to "
                        + castingToType(diff.getNewValue()));
                case "noChange" -> { }
                default -> throw new IllegalStateException("Unexpected value: " + diff.getState());
            }
        }

        return result.toString();
    }

    private static String castingToType(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
