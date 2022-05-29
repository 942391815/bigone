package chapter2;

/**
 * 面试题5:替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换为20%。例如：输入"we are happy."
 * 则输出"we%20are%20happy"
 */
public class Code5 {
    public static void main(String[] args) {
        String ss = "we are happy";
        char[] chars = ss.toCharArray();
        char[] chars1 = new char[16];
        for (int i = 0; i < chars1.length; i++) {
            if (i < chars.length) {
                chars1[i] = chars[i];
            } else {
                chars1[i] = '\n';
            }

        }

        replaceBank(chars1);
        System.out.println(chars1);
    }

    static void replaceBank(char str[]) {
        if (str == null || str.length == 0) {
            return;
        }
        int index = 0;
        char empty = ' ';
        while (str[index] != '\n') {
            //找到第一个无效元素
            index = index + 1;
        }
        //找到最后一个有效的元素，从最后copy
        index--;
        int end = str.length - 1;

        while (index >= 0) {
            if (str[index] != ' ') {
                //非empty case
                str[end] = str[index];
                end--;
            } else {
                //%20
                str[end--] = '0';
                str[end--] = '2';
                str[end--] = '%';
            }

            index--;
        }
    }
}
