package six;

/**
 * @Date 2020/6/29 18:52
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code215 {
    public static void main(String[] args) {
        int nums[] = {8166, 1064, 8508};
        int k = 1;
        Code215 code215 = new Code215();
        System.out.println(code215.findKthLargestV1(nums, k));
        System.out.println(code215.heapSort(nums, k));
    }


    public int heapSort(int array[], int k) {
        int size = array.length;
        for (int i = size / 2; i >= 0; i--) {
            heapfy(array, i, size);
        }

        for (int i = array.length - 1; i >= array.length - k + 1; i--) {
            swap(array, 0, i);
            size--;
            heapfy(array, 0, size);
        }
        return array[0];
    }


    public void heapfy(int array[], int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, largest, i);
            heapfy(array, largest, size);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * heap sort
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestV2(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }


    public int findKthLargestV1(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int array[], int start, int end) {
        if (start >= end) {
            return;
        }
        int key = array[start];
        int low = start;
        int high = end;

        while (low < high) {
            while (array[high] >= key && high > low) {
                high--;
            }
            array[low] = array[high];
            while (array[low] <= key && high > low) {
                low++;
            }
            array[high] = array[low];
            array[low] = key;
            quickSort(array, start, low - 1);
            quickSort(array, low + 1, end);
        }
    }
}