import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<Integer> duplicateElements(Stream<Integer> stream) {

        final List<Integer> collect = stream.filter(s -> s != null).collect(Collectors.toList());
        return collect.stream().filter(s -> s != null).filter(i -> Collections.frequency(collect, i) > 1).distinct().sorted();
    }
}
