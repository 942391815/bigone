package middle.video2;

/**
 * 判断（）是否完整，如果（）不完整则需要最少添加多少个括号
 */
public class Brackets {
    public static void main(String[] args) {
        String ss = "(()))(";
        System.out.println(getMinHandleCount(ss));
    }

    /**
     * 分析：如何判断一个（）是否完整 比如：（（））（（）
     * demo是不完整的，因为少了一个）括号，添加上）的操作为数量为1
     * 可以定义一个count为0 左括号为1 有括号-1 则遍历到最后为count=0表示为完整括号
     * 如果遍历的过程中count<0 则表示需要添加一个左括号 此时操作次数+1，把count置为0
     * 遍历到最后count为剩余的操作，则一共表示需要的次数
     *
     * @param s
     * @return
     */
    public static int getMinHandleCount(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }

            if (count == -1) {
                result = result - count;
                count = 0;
            }
        }
        return result + count;
    }
}
