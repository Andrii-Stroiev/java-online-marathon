import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        int maxValue = 0;
        for (Integer value : numbers) {
            if (pr.test(value)) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction, Predicate<Integer> predicate) {

        return biFunction.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {

        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
    }
}
