package video2;

/**
 * 小和问题
 * 1，2，5 小和为 1+1+2=4 左边数字比当前数字小的为小和 故为 1+1+2=4
 */
public class MinSum {

    public static void main(String[] args) {
        int array[] = {1, 3, 4, 2, 5};
        System.out.println(mergeSortPartition(array, 0, array.length - 1));
    }

    /**
     * 归并排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static int mergeSortPartition(int array[], int left, int right) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (left >= right) {
            return 0;
        }
        int middle = (left + right) / 2;
        int result =
                mergeSortPartition(array, left, middle) +
                        mergeSortPartition(array, middle + 1, right) +
                        mergeSort(array, left, middle, right);
        return result;
    }

    /**
     * 归并排序
     */
    public static int mergeSort(int array[], int start, int middle, int end) {
        if (start == end) {
            return 0;
        }
        int result = 0;
        int temp[] = new int[end - start + 1];
        int left = start;
        int right = middle + 1;
        int index = 0;
        while (left <= middle && right <= end) {
            if (array[left] < array[right]) {
                result = result + array[left] * (end - right + 1);
            }
            temp[index++] = array[left] < array[right] ? array[left++] : array[right++];

        }
        while (left <= middle) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        for (int i = start; i <= end; i++) {
            array[i] = temp[i - start];
        }
        return result;
    }
}
