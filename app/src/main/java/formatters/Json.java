package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

public final class Json {
    private Json() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(LinkedHashMap<String, LinkedHashMap<String, Object>> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        StringJoiner result = new StringJoiner(",");
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
        return getPrintFormatJson("{" + result.toString() + "}");
    }
    public static String getPrintFormatJson(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            JsonNode json = objectMapper.readTree(data);
            return objectMapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
