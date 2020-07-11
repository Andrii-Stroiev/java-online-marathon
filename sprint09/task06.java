import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        List<String> collect = list.stream().filter(s->s!=null)
                .flatMap(e -> e.filter(n -> n != null && !n.trim().isEmpty() && !n.isEmpty())
                        .map(s -> stringFormatter(s)))
                .distinct()
                .collect(toList());
        Map<String, List<String>> map = collect.stream()
                .collect(Collectors.groupingBy(c -> c.length() == 10 ? c.substring(0, 3) : c.length() == 7 ? "loc" : "err"
                        , Collectors.mapping(c -> c.length() == 10 ? c.substring(3) : c, toList())));
        return map.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue().stream().sorted()));
    }

    private static String stringFormatter(String phoneNumber) {
        return phoneNumber.replaceAll(" ", "").replaceAll("\\p{P}", "");
    }
}
