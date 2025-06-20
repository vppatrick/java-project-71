package hexlet.code;

import java.util.Map;
import java.util.concurrent.Callable;

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
    @Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: stylish]")
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
        var result = Differ.generate(filePath1, filePath2, format);
        System.out.println(result);
        return 0;
    }
}
