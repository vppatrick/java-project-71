package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Formatter {
    private Formatter() {
        throw new IllegalStateException("Utility class");
    }
    public static String getData(Map<String, LinkedHashMap<String, Object>> data, String format) throws Exception {
        if (format.equals("stylish")) {
            return Stylish.getFormat(data);
        } else if (format.equals("plain")) {
            return Plain.getFormat(data);
        } else if (format.equals("json")) {
            return Json.getFormat(data);
        } else {
            throw new RuntimeException("Unknown format: " + format);
        }
    }
}
