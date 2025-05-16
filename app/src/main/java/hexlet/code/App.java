package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference."
)
public class App implements Runnable {
    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
