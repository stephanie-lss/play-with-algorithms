/**
 * @author LiSheng
 * @date 2020/1/12 17:33
 */
public class HeapSort {

    public static void sort(Integer[] arr) {
        int n = arr.length;

        //堆化
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            siftDown(arr, n, i);
        }

        //原地堆排序
        //每次交换后都将前i个元素进行下移操作
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, i, 0);//i个元素
        }
    }

    private static void siftDown(Integer[] arr, int i, int j) {
        while (2 * j + 1 < i) {
            int t = 2 * j + 1;
            if (t + 1 < i && arr[t + 1].compareTo(arr[t]) > 0) {
                t += 1;
            }
            if (arr[j].compareTo(arr[t]) > 0) {
                break;
            } else {
                swap(arr, t, j);
                j = t;
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("HeapSort", arr);
    }
}
