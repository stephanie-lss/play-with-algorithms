import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/1/11 9:43
 */
public class QuickSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);

    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSort(arr,l,r);
            return;
        }
        /*int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);*/
        int[] res = partition3(arr, l, r);
        quickSort(arr, l, res[0] - 1);
        quickSort(arr, res[1], r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p，使得arr[l...p-1] < arr[p]; arr[p+1...r]>arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l) + l));
        Comparable v = arr[l];
        // arr[l+1...j]<v ; arr[j+1...i)>v
        int j = l; //此时小于v的数组为空
        for (int i = j + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, ++j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    //返回p，使得arr[l+1,i)<v ; arr(j,r]>=v
    private static int partition2(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l) + l));
        Comparable v = arr[l];
        int i = l + 1;//此时小于v的数组为空
        int j = r;//此时大于等于v的数组为空
        while (true) {
            while (i <= j && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(v) > 0) {
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

    //返回lt，rt，使得arr[l+1,lt]<v ; arr[lt,gt-1]=v; arr[gt,r]>v
    private static int[] partition3(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l) + l));
        Comparable v = arr[l];
        int lt = l; //此时小于v的数组为空
        int gt = r + 1; //此时大于v的数组为空
        int i = lt + 1;
        while (i != gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, ++lt);
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        int[] res = {lt, gt};
        return res;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

        //测试存在大量重复值的数组
        Integer[] arr5 = SortTestHelper.generateRandomArray(n, 0, 10);
        Integer[] arr6 = Arrays.copyOfRange(arr5, 0, arr5.length);
        SortTestHelper.testSort("QuickSort", arr5);
        SortTestHelper.testSort("MergeSort", arr6);
    }
}
