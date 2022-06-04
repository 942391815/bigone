package video2;

public class QuickSort {
    public static void main(String[] args) {
        int array[] = {7, 7, 5, 7, 6, 3, 9};
        quickSort(array);
        MergeSort.printArray(array);
    }

    public static void quickSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int array[], int left, int right) {
        if (left < right) {
            int middle = partition(array, left, right);
            quickSort(array, left, middle - 1);
            quickSort(array, middle + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }
}
