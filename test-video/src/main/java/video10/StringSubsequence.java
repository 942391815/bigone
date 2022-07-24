package video10;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的子序列
 * 打印数字的所有子序列
 * 其中 比如 ab 可以 为 a、b、ab和 ""
 */
public class StringSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        getSubStr(str.toCharArray(), 0, new ArrayList<Character>());
    }

    /**
     * 递归方法
     *
     * @param str
     * @param index
     * @param res
     */
    public static void getSubStr(char[] str, int index, List<Character> res) {
        //如果到末尾则直接返回
        if (index == str.length) {
            System.out.println(res);
            return;
        }
        List<Character> resKeep = copyArray(res);
        resKeep.add(str[index]);
        getSubStr(str, index + 1, resKeep);

        List<Character> resNoKeep = copyArray(res);
        getSubStr(str, index + 1, resNoKeep);
    }

    static List<Character> copyArray(List<Character> res) {
        List<Character> result = new ArrayList<>();
        result.addAll(res);
        return result;
    }
}
