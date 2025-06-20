import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import hexlet.code.Parser;

class ParserClassTest {
    @Test
    // Тест парсинга несуществующего файла
    void testParserNoFile() throws Exception {
        var path = Paths.get("src", "test", "resources", "nofile.json")
                .toAbsolutePath().normalize().toString();
        Exception expected = new Exception("File '" + path + "' does not exist");
        try {
            Parser.getData("src/test/resources/nofile.json");
        } catch (Exception actual) {
            assertEquals(expected.getMessage(), actual.getMessage());
        }
    }
}
