import java.util.*;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract double getArea();

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return getName().equals(shape.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRadius());
    }
}

class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    double getArea() {
        return getHeight() * getWidth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getHeight(), getHeight()) == 0 &&
                Double.compare(rectangle.getWidth(), getWidth()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHeight(), getWidth());
    }
}

class AreaOfShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        if (s1.getArea() > s2.getArea()) {
            return 1;
        }
        if (s1.getArea() < s2.getArea()) {
            return -1;
        } else
            return 0;
    }
}

class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> maxAreasOfShapes = new ArrayList<>();
        Set<Rectangle> rectangles = new HashSet<>();
        Set<Circle> circles = new HashSet<>();

        for (Shape shape : shapes) {
            if (shape != null) {
                if (shape instanceof Rectangle) {
                    rectangles.add((Rectangle) shape);
                }
                if (shape instanceof Circle) {
                    circles.add((Circle) shape);
                }
            }
        }

        AreaOfShapeComparator areaOfShapeComparator = new AreaOfShapeComparator();
        for (Rectangle rectangle : rectangles) {
            if (Collections.max(rectangles, areaOfShapeComparator).getArea() == rectangle.getArea()) {
                maxAreasOfShapes.add(rectangle);
            }
        }
        for (Circle circle : circles) {
            if (Collections.max(circles, areaOfShapeComparator).getArea() == circle.getArea()) {
                maxAreasOfShapes.add(circle);
            }
        }
        return maxAreasOfShapes;
    }
}
