package video2;

/**
 * 数组逆序对
 * Reverse order
 * 7,5,6,4 逆序对 {7,5}，{7,6}，{7,4}，{5,4}，{6,4} 为5
 */
public class ReverseOrder {
    public static void main(String[] args) {
        int array[] = {1, 3, 2, 3, 1};
        System.out.println(mergeSortPartition(array, 0, array.length - 1));
    }

    public int reversePairs(int[] nums) {
        return mergeSortPartition(nums, 0, nums.length - 1);
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
     * 7,5,6,4 逆序对 {7,5}，{7,6}，{7,4}，{5,4}，{6,4}
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
            if (array[left] > array[right]) {
                result = result + (end - right + 1);
            }
            temp[index++] = array[left] > array[right] ? array[left++] : array[right++];

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
