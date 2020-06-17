import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DrinkReceipt {
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        ingredients = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Water", 100).
                addComponent("Arabica", 20);
        return ingredients;
    }

}

class Espresso extends Caffee {
    private Map<String, Integer> ingredients;

    public Espresso(String name, int rating) {
        super(name, rating);
        ingredients = new HashMap<>();

    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Water", 50).
                addComponent("Arabica", 20);
        return ingredients;
    }
}

class Cappuccino extends Caffee {
    private Map<String, Integer> ingredients;

    public Cappuccino(String name, int rating) {
        super(name, rating);
        ingredients = new HashMap<>();
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Water", 100).
                addComponent("Arabica", 20).
                addComponent("Milk", 50);
        return ingredients;
    }
}

class MyUtils {
    public  Map<String, Double> averageRating(List<Caffee> coffees) {
        Map<String, Double> coffeesRating = new HashMap<>();
        int totalCaffeeRating = 0;
        int numberOfCaffeeRating = 0;
        int totalCappuccinoRating = 0;
        int numberOfCappuccinoRating = 0;
        int totalEspressoRating = 0;
        int numberOfEspressoRating = 0;
        for (Caffee caffee : coffees) {
            if (caffee.getName() == "Caffee") {
                totalCaffeeRating += caffee.getRating();
                numberOfCaffeeRating++;
            } else if (caffee.getName() == "Cappuccino") {
                totalCappuccinoRating += caffee.getRating();
                numberOfCappuccinoRating++;
            } else {
                totalEspressoRating += caffee.getRating();
                numberOfEspressoRating++;
            }
            if (numberOfCaffeeRating > 0) {
                coffeesRating.put("Caffee", totalCaffeeRating / (double) numberOfCaffeeRating);
            }
            if (numberOfCappuccinoRating > 0) {
                coffeesRating.put("Cappuccino", totalCappuccinoRating / (double) numberOfCappuccinoRating);
            }
            if (numberOfEspressoRating > 0) {
                coffeesRating.put("Espresso", totalEspressoRating / (double) numberOfEspressoRating);
            }
        }
        return coffeesRating;
    }
}
