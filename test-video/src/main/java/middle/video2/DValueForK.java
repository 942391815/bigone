package middle.video2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 一个数组中求差值为K的数字对
 */
public class DValueForK {

    public static void main(String[] args) {
        int array[] = {1, 3, 5, 7, 9, 10};
        int k = 2;
        System.out.println(getPair(array,k));
    }

    public static int getPair(int array[], int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int target = array[i] + k;
            if (set.contains(target)) {
                count++;
            }
        }
        return count;
    }
}
