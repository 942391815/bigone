package chapter2;

/**
 * 第二章：
 * 找出数组中重复的数字
 */
public class Code3 {
    public static void main(String[] args) {
//        int oneArray[] = {2, 3, 1, 0, 2, 5, 3};
//        System.out.println(findRepeat1(oneArray));
        int twoArray[] = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findRepeat2(twoArray));

    }

    /**
     * 题目二：不修改数组找出重复的数字
     * 在一个长度为N+1的数组里的所有数字都在1-N的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的
     * 数组，但不能修改输入的数组。例如：如果输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的数组是重复的数组2或者3
     * <p>
     * 如果不考虑时间空间复杂度，则可以直接copy原数组 需要空间复杂度为O(N)
     * 此方法的空间复杂度为O(1).能查找出来的数据不是很准确，一定case会有漏掉 二分查找
     */
    public static Integer findRepeat2(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (array[i] < 1 || array[i] > size) {
                return null;
            }
        }
        //主要是基于二分查找 比如8/2 为4 则在前四个数组中查看是4个数字 如果是则查看右半部分
        //如果值考虑0(1)的空间复杂度
        int start = 1;
        int end = array.length - 1;
        while (end >= start) {
            int middle = (end + start) / 2;
            int count = countNum(array, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    //数组array start上边界 end 下边界
    static int countNum(int array[], int start, int end) {
        int count = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= start && array[i] <= end) {
                count++;
            }
        }
        return count;
    }

    /**
     * * 在一个长度为N的数组里的所有数字都在0-（N-1）的范围内。数组中某些数字是重复的。但不知道有几个数字重复了
     * * 也不知道每个数字重复了几次。请找出数组任意一个重复数字。
     * * 例如：如果数组长度为7的数组{2,3,1,0,2,5,3} 那么对应的输出重复数字2或者3
     */
    public static Integer findRepeat1(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int size = array.length;
        //合法性校验数字的范围在 N-1
        for (int i = 0; i < size; i++) {
            if (array[i] >= size - 1 || array[i] < 0) {
                return null;
            }
        }
        //挨个元素检查
        for (int i = 0; i < array.length; i++) {
            //如果当前元素值和下标不相等，则置换到下位位置
            //{2,3,1,0,2,5,3}
            while (array[i] != i) {
                int num = array[i];
                if (array[i] == array[num]) {
                    return array[i];
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return null;
    }
}
