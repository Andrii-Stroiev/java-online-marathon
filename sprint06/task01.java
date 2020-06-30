import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {
  
    public static int getCount(int[] array, Predicate<Integer> function ) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (function.test(array[i])) counter++;
        }
        return counter;
    }

}
