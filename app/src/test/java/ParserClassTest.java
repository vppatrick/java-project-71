import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import hexlet.code.Parser;

public class ParserClassTest {
    @Test
    // Тест парсинга несуществующего файла
    public void testParserNoFile() throws Exception {
        Exception expected = new Exception("File '/home/vitaliy/java-project-71/"
                + "app/src/test/resources/nofile.json' does not exist");
        try {
            var result = Parser.getData("src/test/resources/nofile.json");
        } catch (Exception actual) {
            assertEquals(expected.getMessage(), actual.getMessage());
        }
    }
}
