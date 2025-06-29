package formatters;

import hexlet.code.DiffDTO;
import java.util.List;
import java.util.StringJoiner;

public final class Stylish {
    private Stylish() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(List<DiffDTO> diffs) {
        StringJoiner result = new StringJoiner("\n");
        result.add("{");

        for (var diff : diffs) {
            switch (diff.getState()) {
                case "added" -> result.add("  + " + diff.getName() + ": " + diff.getValue());
                case "removed" -> result.add("  - " + diff.getName() + ": " + diff.getValue());
                case "noChange" -> result.add("    " + diff.getName() + ": " + diff.getValue());
                default -> {
                    result.add("  - " + diff.getName() + ": " + diff.getOldValue());
                    result.add("  + " + diff.getName() + ": " + diff.getNewValue());
                }
            }
        }

        return result.add("}").toString();
    }
}
