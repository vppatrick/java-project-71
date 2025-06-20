package hexlet.code;

import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class Parser {
    private Parser() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFileExtension(String fileName) {
        var dotIndex = fileName.lastIndexOf('.');
        return dotIndex >= 0 ? fileName.substring(dotIndex + 1) : "";
    }
    public static Map<String, Object> getData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        // Проверяем существование файла
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        // Читаем файл
        String content = Files.readString(path);

        // Определяем росширение файла
        var fileExtension = getFileExtension(filePath);
        ObjectMapper mapper = null;
        if (fileExtension.equals("json")) {
            mapper = new ObjectMapper();
            return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        } else if (fileExtension.equals("yml")) {
            mapper = new YAMLMapper();
            return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        }

        return Map.of();
    }
}
