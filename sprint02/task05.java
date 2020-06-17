import java.util.ArrayList;
import java.util.List;

class Rectang {
    private double height;
    private double width;

    public Rectang(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getPerimeter() {
        return (height * 2 + width * 2);
    }
}

class Square extends Rectang {

    public Square(double width) {
        super(width, width);
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

}

public class MyUtils {
    public double sumPerimeter(List<Rectang> firures) {
        int totalPerimeter = 0;
        for (Rectang figure : firures) {
            if (figure != null) {
                totalPerimeter += figure.getPerimeter();
            }
        }
        return totalPerimeter;
    }
}
