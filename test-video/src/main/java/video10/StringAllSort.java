package video10;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串全排列
 * 比如 ab 可以为 ab ba
 */
public class StringAllSort {
    public static void main(String[] args) {
        String str = "01";
        allSort(str.toCharArray(), 0);
    }

    /**
     * 字符全排列
     *
     * @param str
     * @param i
     */
    public static void allSort(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }

        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            allSort(str, i + 1);
            swap(str, i, j);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    List<Character> copyList(List<Character> list) {
        List<Character> result = new ArrayList<>();
        result.addAll(list);
        return result;
    }
}
