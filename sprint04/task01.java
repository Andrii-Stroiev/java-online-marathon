import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MyUtils {
    // Code
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> namePhones = new HashMap<>();
       for (Map.Entry<String, String> entry: phones.entrySet()){
           namePhones.put(entry.getValue(),new ArrayList<>());
       }
       for (Map.Entry<String, String> entry: phones.entrySet()){
           namePhones.get(entry.getValue()).add(entry.getKey());
       }


        return namePhones;
    }

}
