/**
 * @author LiSheng
 * @date 2020/1/8 21:35
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //寻找[i,n]区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int minIndex) {
        Object tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }

    public static void main(String[] args) {
        //test Performance
        int n = 100000;
        Integer[] array = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("SelectionSort", array);
    }
}
