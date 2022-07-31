package video12;

/**
 * KMP算法
 * 串：   abbcabbct....
 * 子串   abbcabbcs....
 * <p>
 * 第一次匹配
 * 串：   abbcabbc    t....
 * 子串   abbcabbc    s....
 * <p>
 * 第二次匹配
 * 串：   abbcabbc t....
 * 子串       abbc a
 * <p>
 * 第三次匹配
 * *  串：   abbcabbc t....
 * *  子串            a....
 */

public class KMP {
    public static int getIndexOf(String s, String m) {
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int next[] = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * 求i位置最长前缀，范围为0-(i-1)个字符
     *
     * @param ms
     * @return
     */
    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int next[] = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        //index为 该下表的字符和i-1位置的字符比较
        int index = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[index]) {
                index = index + 1;
                next[i] = index;
                i++;
            } else if (index > 0) {
                index = next[index];
            } else {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }
}
