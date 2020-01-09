/**
 * @author LiSheng
 * @date 2020/1/9 13:03
 * 优化插入排序：不用每次都交换两个数，只是赋值
 * 对于大部分有序的数组，插入排序性能比选择排序好
 */
public class InsertionSort2 {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable tmp = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (tmp.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = tmp;
        }
    }

    private static void swap(Object[] arr, int i, int minIndex) {
        Object tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] array = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] array2 = SortTestHelper.generateNearlyOrderedArray(n, 100);
        SortTestHelper.testSort("InsertionSort", array2);

        array = SortTestHelper.generateRandomArray(n, 0, n);
        array2 = SortTestHelper.generateNearlyOrderedArray(n, 100);
        SortTestHelper.testSort("InsertionSort2", array2);

        array = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("SelectionSort", array);
    }
}
