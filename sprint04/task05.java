class ArrayUtil {
    public static <T extends Number>  double averageValue(Array<T> array) {
        double sum = 0.0;
        for (int i = 0; i < array.length(); i++) {
           sum+= array.get(i).doubleValue();
        }
        return  sum /array.length();
    }
}
