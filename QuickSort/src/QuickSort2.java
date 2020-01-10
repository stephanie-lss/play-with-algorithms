import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/1/10 20:20
 */
public class QuickSort2 {
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
        int[] res = quick3Way(arr, l, r);
        quickSort(arr, l, res[0] - 1);
        quickSort(arr, res[1], r);
    }

    /**
     * 三路快速排序处理 arr[l...r]
     * 将arr[l...r]分为 <v ； =v; >v;
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int[] quick3Way(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l) + l));
        Comparable v = arr[l];
        // arr[l+1...lt]<v ; arr[lt+1...i-1]=v ; arr[gt...r]>0
        int lt = l, gt = r + 1;
        for (int i = l + 1; i < gt; i++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, lt + 1, i);
                lt++;
//                i++;
            } else if (arr[i].compareTo(v) == 0) {
//                i++;
            } else {
                swap(arr, --gt, i);
                i--;
            }
        }
        /*int i = l + 1;
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, lt + 1, i);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) == 0) {
                i++;
            } else {
                swap(arr, --gt, i);
            }
        }*/
        swap(arr, l, lt);
//        quick3Way(arr, l, lt - 1);
//        quick3Way(arr, gt, r);
        int[] res = {lt, gt};
        return res;
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
        SortTestHelper.testSort("QuickSort2", arr);
        SortTestHelper.testSort("MergeSort", arr2);

        //测试基本有序的数组
        Integer[] arr3 = SortTestHelper.generateNearlyOrderedArray(n, 100);
        Integer[] arr4 = Arrays.copyOfRange(arr3, 0, arr3.length);
        SortTestHelper.testSort("QuickSort2", arr3);
        SortTestHelper.testSort("MergeSort", arr4);

        Integer[] arr5 = SortTestHelper.generateRandomArray(n, 0, 10);
        Integer[] arr6 = Arrays.copyOfRange(arr5, 0, arr5.length);
        SortTestHelper.testSort("QuickSort2", arr5);
        SortTestHelper.testSort("MergeSort", arr6);


    }
}
