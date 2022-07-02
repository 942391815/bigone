package utils;

public class ArrayUtils {
    public static void printArray(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int each : array) {
            System.out.println(each);
        }
    }
}
