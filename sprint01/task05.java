//A Point class, which models a 2D point with x and y coordinates should contains:
//1.Two private instance variables x and y  of int type.
//2.A constructor that constructs a point with the given x and y coordinates.
//3.A method getXYPair() which returns the x and y in a 2-element int array.
//4.A method called distance(int x, int y) that returns the distance from this point to another point at the given (x, y) coordinates.
//5.An overloaded distance(Point point) method that returns the distance from this point to the given Point instance.
//6.Another overloaded distance() method that returns the distance from this point to the origin (0, 0)

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXYPair(){
        int [] xyPair = new int[2];
        xyPair[0] = x;
        xyPair[1] = y;
        return  xyPair;
    }
    public double distance (int x, int y){
        double d = Math.sqrt(Math.pow((x -this.x),2)+Math.pow((y-this.y),2));
        return  d;
    }
    public double distance (Point point){
        double d = Math.sqrt(Math.pow((point.getX() -this.x),2)+Math.pow((point.getY()-this.y),2));
        return  d;
    }
    public double distance (){
        double d = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
        return  d;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
