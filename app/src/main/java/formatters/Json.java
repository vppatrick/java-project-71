package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public final class Json {
    private Json() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(Map<String, LinkedHashMap<String, Object>> data) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        StringJoiner result = new StringJoiner(",");
        for (var entry : data.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (!value.get("state").equals("noChange")) {
                result.add("\"" + key + "\": " + objectMapper.writeValueAsString(value));
            }
        }
        return getPrintFormatJson("{" + result + "}");
    }
    public static String getPrintFormatJson(String data) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        JsonNode json = objectMapper.readTree(data);
        return objectMapper.writeValueAsString(json);
    }
}
