/**
 * @author LiSheng
 * @date 2020/1/9 13:03
 */
public class InsertionSort {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void insertionSort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > l && e.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int minIndex) {
        Object tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] array = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("InsertionSort", array);
        SortTestHelper.testSort("SelectionSort", array);
    }
}
