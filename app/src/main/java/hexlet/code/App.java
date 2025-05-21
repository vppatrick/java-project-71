package hexlet.code;

import java.util.Map;
import java.util.concurrent.Callable;

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
public class App implements Callable<Integer> {
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
    public Integer call() {
        Map<String, String> firstMapOfJson;
        try {
            firstMapOfJson = Parsing.getData(filePath1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Map<String, String> secondMapOfJson;
        try {
            secondMapOfJson = Parsing.getData(filePath2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        var result = Differ.generate(firstMapOfJson, secondMapOfJson);
        System.out.println(result);
        return 0;
    }
}
