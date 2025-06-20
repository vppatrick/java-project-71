import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import hexlet.code.Differ;

class DifferClassTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    static String normalizeLineEndings(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.replace("\r\n", "\n").replace("\r", "\n");
    }

    @Test
    // Сравнение двух стандартных json файлов
    void testDiffJsonNormal() throws Exception {
        var filePath1 = "src/test/resources/file1.json";
        var filePath2 = "src/test/resources/file2.json";
        var expected = normalizeLineEndings(readFixture("result1"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение двух json файлов с одинаковыми ключами и разными значениями
    void testDiffJsonValues() throws Exception {
        var filePath1 = "src/test/resources/file1.json";
        var filePath2 = "src/test/resources/file3.json";
        var expected = normalizeLineEndings(readFixture("result2"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение json файла с пустым файлом
    void testDiffJsonEmpty() throws Exception {
        var filePath1 = "src/test/resources/file1.json";
        var filePath2 = "src/test/resources/file4.json";
        var expected = normalizeLineEndings(readFixture("result3"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение двух стандартных yaml файлов
    void testDiffYamlNormal() throws Exception {
        var filePath1 = "src/test/resources/file1.yml";
        var filePath2 = "src/test/resources/file2.yml";
        var expected = normalizeLineEndings(readFixture("result1"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение двух yaml файлов с одинаковыми ключами и разными значениями
    void testDiffYamlValues() throws Exception {
        var filePath1 = "src/test/resources/file1.yml";
        var filePath2 = "src/test/resources/file3.yml";
        var expected = normalizeLineEndings(readFixture("result2"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение yaml файла с пустым файлом
    void testDiffYamlEmpty() throws Exception {
        var filePath1 = "src/test/resources/file1.yml";
        var filePath2 = "src/test/resources/file4.yml";
        var expected = normalizeLineEndings(readFixture("result3"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение двух yaml файлов с вложенными структурами в формате stylish
    void testDiffYamlNestedStylish() throws Exception {
        var filePath1 = "src/test/resources/file5.yml";
        var filePath2 = "src/test/resources/file6.yml";
        var expected = normalizeLineEndings(readFixture("result4"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение двух yaml файлов с вложенными структурами в формате plain
    void testDiffYamlNestedPlain() throws Exception {
        var filePath1 = "src/test/resources/file5.yml";
        var filePath2 = "src/test/resources/file6.yml";
        var expected = normalizeLineEndings(readFixture("result5"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "plain"));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение двух json файлов с вложенными структурами в формате json
    void testDiffYamlNestedJson() throws Exception {
        var filePath1 = "src/test/resources/file5.yml";
        var filePath2 = "src/test/resources/file6.yml";
        var expected = normalizeLineEndings(readFixture("result6"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "json"));
        assertEquals(expected, actual);
    }
}
