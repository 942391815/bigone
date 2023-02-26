package foundation.video3;

import utils.ArrayUtils;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int array[] = {1, 4, 2, 1, 0, 10, -1};
        heapSort(array);
        ArrayUtils.printArray(array);
    }

    public static void heapSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        //从最后一个非叶子节点进行建堆
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, i, size);
        }
        for (int j = array.length - 1; j >= 0; j--) {
            swap(array, 0, j);
            heapify(array, 0, j);
        }
    }

    /**
     * 堆化
     *
     * @param array  数组
     * @param i      数组最大值的位置
     * @param length 数组的长度
     */
    public static void heapify(int array[], int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < length && array[left] > array[max]) {
            max = left;
        }
        if (right < length && array[right] > array[max]) {
            max = right;
        }
        if (max != i) {
            swap(array, i, max);
            heapify(array, max, length);
        }
    }

    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
