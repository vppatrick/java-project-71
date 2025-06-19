package hexlet.code;

import formatters.Plain;
import formatters.Stylish;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Formatter {
    public static String getData(LinkedHashMap<String, HashMap<String, Object>> data, String format) {
        if (format.equals("stylish")) {
            return Stylish.getFormat(data);
        } else if (format.equals("plain")) {
            return Plain.getFormat(data);
        } else {
            return "invalid format";
        }
    }
}
