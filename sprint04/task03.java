import java.util.*;

public class MyUtils {
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        Set<String> setFromList = new HashSet<>(list);
        Set<String> setFromMap = new HashSet<>(map.values());
        return setFromList.equals(setFromMap);
    }
}
