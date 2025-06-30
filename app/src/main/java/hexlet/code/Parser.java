package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class Parser {
    private Parser() {
        throw new IllegalStateException("Utility class");
    }
    public static Map<String, Object> getData(String data, String format) throws Exception {
        ObjectMapper mapper = null;

        if (format.equals("json")) {
            mapper = new ObjectMapper();
            return mapper.readValue(data, new TypeReference<Map<String, Object>>() { });
        } else if (format.equals("yml") || format.equals("yaml")) {
            mapper = new YAMLMapper();
            return mapper.readValue(data, new TypeReference<Map<String, Object>>() { });
        }

        return Map.of();
    }
}
