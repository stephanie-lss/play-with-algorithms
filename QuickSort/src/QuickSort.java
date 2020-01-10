import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/1/10 20:20
 */
public class QuickSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //对arr[l...r]部分进行快速排序
        quickSort(arr, 0, n - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }
        int p = partition2(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p，使得arr[l...p-1] < arr[p]; arr[p+1...r]>arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l) + l));
        Comparable v = arr[l];
        int j = l;
        // arr[l+1...j]<v ; arr[j+1...i)>v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static int partition2(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l) + l));
        Comparable v = arr[l];
        // arr[l+1...i)<=v ; arr(j...r]>=v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int j, int i) {
        Object tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("QuickSort", arr);
        SortTestHelper.testSort("MergeSort", arr2);

        //测试基本有序的数组
        Integer[] arr3 = SortTestHelper.generateNearlyOrderedArray(n, 100);
        Integer[] arr4 = Arrays.copyOfRange(arr3, 0, arr3.length);
        SortTestHelper.testSort("QuickSort", arr3);
        SortTestHelper.testSort("MergeSort", arr4);

        Integer[] arr5 = SortTestHelper.generateRandomArray(n, 0, 10);
        Integer[] arr6 = Arrays.copyOfRange(arr5, 0, arr5.length);
        SortTestHelper.testSort("QuickSort", arr5);
        SortTestHelper.testSort("MergeSort", arr6);


    }
}
