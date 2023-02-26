package foundation.video10;

/**
 * N皇后问题
 * 是指在N*N的棋盘上摆N个皇后，要求任何两个皇后不同行，不同列，也不在同一条斜线上
 * 给定一个整数N，返回N皇后的摆法有多少中
 * n=1返回1
 * n=2或者3，2皇后和3皇后无论怎么摆放都不行返回0
 * n=8返回92
 */
public class NQueen {
    public static void main(String[] args) {

    }

    public static int process1(int i, int record[], int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res = res + process1(i + 1, record, n);
            }
        }
        return res;
    }

    /**
     * 只看record [0...i-1]位置 只看前面，不看后面
     *
     * @param record record[i]表示第i行的皇后在第几列上
     * @param i      代表行
     * @param j      代表列
     * @return
     */
    private static boolean isValid(int[] record, int i, int j) {
        //i代表行，j代表列  从第0行检查每一列是否正确
        for (int k = 0; k < i; k++) {
            //不共列，不共斜线
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return false;
    }
}
