public class Sort {
    public static void main(String[] args) {
        int array[] = {1, -1, 0, 4, 100, 0, 50};
        bubbleSort(array);
        System.out.println(array);
    }

    private static void bubbleSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
