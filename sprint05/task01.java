class Operation {
    public static int squareRectangle(int a, int b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("both arguments should be more than zero");
        } else return a * b;
    }

    public static int trySquareRectangle(int a, int b) {
        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {

            return -1;
        }
    }
}
