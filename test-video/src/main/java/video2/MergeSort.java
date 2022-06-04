package video2;

public class MergeSort {

    public static void main(String[] args) {
        int array[] = {7, 6, 5, 4, 3, 2, 1, 0, -1};
        mergeSortPartition(array, 0, array.length - 1);
        printArray(array);
    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    /**
     * 归并排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSortPartition(int array[], int left, int right) {
        if (array == null || array.length == 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSortPartition(array, left, middle);
        mergeSortPartition(array, middle + 1, right);
        mergeSort(array, left, middle, right);
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int array[], int start, int middle, int end) {
        if (start == end) {
            return;
        }
        int temp[] = new int[end - start + 1];
        int left = start;
        int right = middle + 1;
        int index = 0;
        while (left <= middle && right <= end) {
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
    }
}
