import java.util.Map;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<String> nameList(Map<String, Stream<String>> map) throws NumberFormatException {

        return map.values().stream()
                .filter(str->str!=null)
                .flatMap(e -> e.filter(n -> n != null && !n.trim().isEmpty() && !n.isEmpty())
                        .map(s -> nameFormatter(s)))
                .distinct().sorted();
    }

    private static String nameFormatter(String name) {
        name = name.replaceAll(" ", "").toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
