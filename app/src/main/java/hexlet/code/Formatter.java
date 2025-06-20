package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;
import java.util.LinkedHashMap;

public final class Formatter {
    private Formatter() {
        throw new IllegalStateException("Utility class");
    }
    public static String getData(LinkedHashMap<String, LinkedHashMap<String, Object>> data, String format) {
        if (format.equals("stylish")) {
            return Stylish.getFormat(data);
        } else if (format.equals("plain")) {
            return Plain.getFormat(data);
        } else if (format.equals("json")) {
            return Json.getFormat(data);
        } else {
            return "invalid format";
        }
    }
}
