package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;

public final class Formatter {
    private Formatter() {
        throw new IllegalStateException("Utility class");
    }
    public static String getData(List<DiffDTO> data, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.getFormat(data);
            case "plain" -> Plain.getFormat(data);
            case "json" -> Json.getFormat(data);
            default -> throw new RuntimeException("Unknown format: " + format);
        };
    }
}
