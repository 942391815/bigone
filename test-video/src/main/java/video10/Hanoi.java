package video10;

/**
 * 汉诺塔问题
 * 从左塔移动到右塔  可借助中间一个空位置
 */
public class Hanoi {
    public static void main(String[] args) {
        hanno(3, "左", "中", "右");
    }

    public static void hanno(int n, String from, String middle, String to) {
        /**
         * 先把N-1个塔 从from移动到middle
         * 然后把第N个塔移从from 动到to塔上
         * 最后吧N-1个塔从middle移动到to塔上
         *
         *
         */

        if (n == 1) {
            System.out.println("把第" + n + "个圆盘 从" + from + " 移动到 " + to);
            return;
        }
        hanno(n - 1, from, to, middle);
        System.out.println("把第" + n + "个圆盘 从:" + from + " 移动到 " + to);
        hanno(n - 1, middle, from, to);
    }
}
