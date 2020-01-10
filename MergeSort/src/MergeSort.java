import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/1/9 19:47
 */
public class MergeSort {


    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
        if (right - left <= 15) {
            InsertionSort.insertionSort(arr, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, left, mid, right);
        }
    }

    public static void merge(Comparable[] arr, int left, int mid, int right) {
        Comparable[] aux = Arrays.copyOfRange(arr, left, right + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) < 0) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("MergeSort",arr);
    }
}
