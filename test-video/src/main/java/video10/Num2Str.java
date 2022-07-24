package video10;

/**
 * 数字转换为字符串
 * 规定1和A对应、2和B对应、3和C对应，那么给定一个数字字符比如"111",就可以转化为"AAA" "KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少中转化结果
 */
public class Num2Str {
    public static void main(String[] args) {
        System.out.println(process("25".toCharArray(), 0));
    }

    public static int process(char[] str, int i) {
        //如果到达末尾则表示1中有效结果
        if (i == str.length) {
            return 1;
        }
//        if (str[i] == '0') {
//            return 0;
//        }
        //第i个字符分为三种case
        //case1:如果当前字符为1  指使用当前字符转化
        //case2:如果当前字符为1，和后序字符一块转化
        //case3:如果当前字符为2，且下一个字符小于等于6则可以和当前字符一块转化
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res = res + process(str, i + 2);
            }
            return res;
        } else if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] <= '6' && str[i + 1] >= '0')) {
                res = res + process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }
}
