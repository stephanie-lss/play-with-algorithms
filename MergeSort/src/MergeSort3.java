/**
 * @author LiSheng
 * @date 2020/1/10 9:12
 * 自底向上进行归并排序
 */
public class MergeSort3 {
    public static void mergeSortBU(Comparable[] arr) {
        int n = arr.length;
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                //对arr[i...i+sz-1] 和 arr[i...i+sz+sz-1]进行归并
                if (sz + sz - 1 <= 15) {
                    InsertionSort.insertionSort(arr, i, i + sz + sz - 1);
                }
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    MergeSort.merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] array = SortTestHelper.generateRandomArray(n, 0, n);
        mergeSortBU(array);
        for (Integer ar : array) {
            System.out.print(ar + " ");
        }
    }
}
