package others;

/**
 * 礼物最大值
 * 纯递归leetcode会导致超时
 */
public class MaxGift {
    public static void main(String[] args) {
//        int gift[][] = {{1, 3, 1}};
//        System.out.println(maxValue(gift));
        int gift[][] = {{1, 3}, {1, 5}};
        System.out.println(maxValue(gift));
    }

    public static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        return getMaxGift(grid, row, column, 0, 0);
    }

    //i代表行 j代表列
    //从第0，0 位置到右下角，每一条路径都有两个选择，向后或者向下
    public static int getMaxGift(int gift[][], int row, int column, int i, int j) {
        if (i == row - 1 && j == column - 1) {
            return gift[i][j];
        }
        int caseRight = 0;
        int caseDown = 0;
        if (j + 1 < column) {
            caseRight = gift[i][j] + getMaxGift(gift, row, column, i, j + 1);
        }
        if (i + 1 < row) {
            caseDown = gift[i][j] + getMaxGift(gift, row, column, i + 1, j);
        }
        return Math.max(caseRight, caseDown);
    }
}
