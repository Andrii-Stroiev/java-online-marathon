class ArrayUtil {
        public static  <T> T setAndReturn(T[] array, T element, int index ){
            array[index] = element;
            return element;
        }
}
