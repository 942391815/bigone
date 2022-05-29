package chapter2;

/**
 * 二维数组中的查找
 * 题目： 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的二位数组
 * 和一个整数，判断数组中是否含有该整数
 * 1    2   8   9
 * 2    4   9   12
 * 4    7   10  13
 * 6    8   11  15
 */
public class Code4 {
    public static void main(String[] args) {
        int array[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(array, 14));
    }

    public static boolean find(int array[][], int num) {
        if (array == null || array.length == 0) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        while (row >= 0 && row < array.length && column >= 0) {
            int benchmark = array[row][column];
            if (benchmark == num) {
                return true;
            } else if (benchmark < num) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

}
