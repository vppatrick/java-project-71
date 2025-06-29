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
    // Сравнение двух json файлов в формате Stylish
    void testDiffJsonStylish() throws Exception {
        var filePath1 = "src/test/resources/file1.json";
        var filePath2 = "src/test/resources/file2.json";
        var expected = normalizeLineEndings(readFixture("resultStylish"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
        // Сравнение двух json файлов в формате Plain
    void testDiffJsonPlain() throws Exception {
        var filePath1 = "src/test/resources/file1.json";
        var filePath2 = "src/test/resources/file2.json";
        var expected = normalizeLineEndings(readFixture("resultPlain"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "plain"));
        assertEquals(expected, actual);
    }

    @Test
        // Сравнение двух json файлов в формате Json
    void testDiffJsonJson() throws Exception {
        var filePath1 = "src/test/resources/file1.json";
        var filePath2 = "src/test/resources/file2.json";
        var expected = normalizeLineEndings(readFixture("resultJson"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "json"));
        assertEquals(expected, actual);
    }

    @Test
        // Сравнение двух json файлов в формате по умолчанию (Stylish)
    void testDiffJsonDefault() throws Exception {
        var filePath1 = "src/test/resources/file1.json";
        var filePath2 = "src/test/resources/file2.json";
        var expected = normalizeLineEndings(readFixture("resultStylish"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2));
        assertEquals(expected, actual);
    }

    @Test
        // Сравнение двух yaml файлов в формате Stylish
    void testDiffYamlStylish() throws Exception {
        var filePath1 = "src/test/resources/file1.yml";
        var filePath2 = "src/test/resources/file2.yml";
        var expected = normalizeLineEndings(readFixture("resultStylish"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expected, actual);
    }

    @Test
        // Сравнение двух yaml файлов в формате Plain
    void testDiffYamlPlain() throws Exception {
        var filePath1 = "src/test/resources/file1.yml";
        var filePath2 = "src/test/resources/file2.yml";
        var expected = normalizeLineEndings(readFixture("resultPlain"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "plain"));
        assertEquals(expected, actual);
    }

    @Test
        // Сравнение двух yaml файлов в формате Json
    void testDiffYamlJson() throws Exception {
        var filePath1 = "src/test/resources/file1.yml";
        var filePath2 = "src/test/resources/file2.yml";
        var expected = normalizeLineEndings(readFixture("resultJson"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2, "json"));
        assertEquals(expected, actual);
    }

    @Test
        // Сравнение двух yaml файлов в формате по умолчанию (Stylish)
    void testDiffYamlDefault() throws Exception {
        var filePath1 = "src/test/resources/file1.yml";
        var filePath2 = "src/test/resources/file2.yml";
        var expected = normalizeLineEndings(readFixture("resultStylish"));
        var actual = normalizeLineEndings(Differ.generate(filePath1, filePath2));
        assertEquals(expected, actual);
    }
}
