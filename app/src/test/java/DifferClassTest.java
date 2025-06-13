import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import hexlet.code.Differ;
import hexlet.code.Parsing;

public class DifferClassTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    public static String normalizeLineEndings(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.replace("\r\n", "\n").replace("\r", "\n");
    }

    @Test
    // Сравнение двух стандартных json файлов
    public void testDiffNormal() throws Exception {
        var firstJson = Parsing.getData("src/test/resources/file1.json");
        var secondJson = Parsing.getData("src/test/resources/file2.json");
        var expected = normalizeLineEndings(readFixture("result1"));
        var actual = normalizeLineEndings(Differ.generate(firstJson, secondJson));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение двух json файлов с одинаковыми ключами и разными значениями
    public void testDiffValues() throws Exception {
        var firstJson = Parsing.getData("src/test/resources/file1.json");
        var secondJson = Parsing.getData("src/test/resources/file3.json");
        var expected = normalizeLineEndings(readFixture("result2"));
        var actual = normalizeLineEndings(Differ.generate(firstJson, secondJson));
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение json файла с пустым файлом
    public void testDiffEmpty() throws Exception {
        var firstJson = Parsing.getData("src/test/resources/file1.json");
        var secondJson = Parsing.getData("src/test/resources/file4.json");
        var expected = normalizeLineEndings(readFixture("result3"));
        var actual = normalizeLineEndings(Differ.generate(firstJson, secondJson));
        assertEquals(expected, actual);
    }
}
