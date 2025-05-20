package hexlet.code;

import java.util.Map;
import hexlet.code.Parsing;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference."
)
public class App implements Runnable {
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public void run() {
        Map<String, String> mapJson1;
        try {
            mapJson1 = Parsing.getData(filePath1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Map<String, String> mapJson2;
        try {
            mapJson2 = Parsing.getData(filePath2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(mapJson2.get("verbose"));
    }
}
