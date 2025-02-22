//Create a Product class with fields name of type String and price of type double.
//The Product class must meet the following principles:
//1.All class fields must be private.
//2.Get and set methods must be used to access the class fields.
//3.The class must have a constructors with and without parameters.
//In the Product class write count() static method that returns count of created objects of Product type.

public class Product {
    private String name;
    private  double price;
   private static int totalProductNumber;

    public Product() {
        totalProductNumber++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        totalProductNumber++;
    }
    
        public static int count(){
        return totalProductNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
