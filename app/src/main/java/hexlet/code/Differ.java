package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String getFileExtension(String fileName) {
        var dotIndex = fileName.lastIndexOf('.');
        return dotIndex >= 0 ? fileName.substring(dotIndex + 1) : "";
    }
    public static String readFile(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        // Проверяем существование файла
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return Files.readString(path);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {
        // Читаем файл
        var firstData = readFile(firstFilePath);
        var secondData = readFile(secondFilePath);

        // Определяем росширение файла
        var firstFileExtension = getFileExtension(firstFilePath);
        var secondFileExtension = getFileExtension(firstFilePath);

        // Парсинг данных из строки
        var firstMapOfData = Parser.getData(firstData, firstFileExtension);
        var secondMapOfData = Parser.getData(secondData, secondFileExtension);

        // Нахождение различий в файлах
        var result = Mapper.getDiff(firstMapOfData, secondMapOfData);
        return Formatter.getData(result, format);
    }
}
