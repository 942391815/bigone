package foundation.video19;

/**
 * 横坐标轴上有N个点，一条长度为L的绳子，求绳子最多能覆盖多少个点
 */
public class LineNode {

    public static void main(String[] args) {
//        int array[] = {2, 4, 8, 9, 12, 17};
        int array[] = {2, 9, 19, 29};
        int line = 5;
        System.out.println(getMaxNode(array, line));
    }

    //滑动窗口方法
    public static int getMaxNode(int array[], int line) {
        if (array == null || array.length == 0 || line == 0) {
            return 0;
        }
        int maxNode = 0;
        int size = array.length;
        int start = 0;
        int end = 0;
        while (start < size && end < size) {
            //小于，则扩大窗口
            if (array[end] - array[start] <= line) {
                maxNode = Math.max(maxNode, end - start + 1);
                end++;
            } else {
                start++;
            }
        }
        return maxNode;
    }
}
