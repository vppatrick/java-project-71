package hexlet.code;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var firstMapOfData = Parser.getData(filePath1);
        var secondMapOfData = Parser.getData(filePath2);
        var result = Mapper.getDiff(firstMapOfData, secondMapOfData);
        return Formatter.getData(result, format);
    }
}
