package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Json {
    public static String getFormat(LinkedHashMap<String, LinkedHashMap<String, Object>> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        StringJoiner result = new StringJoiner(",\n");
        for (var key : data.keySet()) {
            var value = data.get(key);
            if (!value.get("state").equals("noChange")) {
                try {
                    result.add("\"" + key + "\": " + objectMapper.writeValueAsString(value));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return "{\n" + result.toString() + "\n}";
    }
}
