import java.util.ArrayList;
import java.util.List;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    DecisionMethod goShopping = (x, y) -> x == "product1" && y > 10;
}
@FunctionalInterface
interface DecisionMethod {
    boolean decide(String productName, int discount);

}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int counter = 0;
        for (DecisionMethod decisionMethod : clients) {
            if (decisionMethod.decide(product, percent)) counter++;
        }
        return counter;
    }
}
