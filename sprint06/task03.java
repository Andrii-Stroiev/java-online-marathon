import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;

public class App {
    static BinaryOperator<String> greetingOperator = (x, y) -> "Hello " + x + " " + y + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator) {
        List<String> greetingList = new ArrayList<>();
        for (Person person : people) {
            greetingList.add(binaryOperator.apply(person.name, person.surname));
        }

        return greetingList;
    }
}
