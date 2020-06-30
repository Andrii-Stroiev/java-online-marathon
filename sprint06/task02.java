import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    static Consumer<double[]> cons = x -> {
        for (int i = 0; i < x.length; i++) {
            x[i] = (x[i] > 2) ? x[i] * 0.8 : x[i] * 0.9;
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] finalArray = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(finalArray);
        return finalArray;
    }
}
