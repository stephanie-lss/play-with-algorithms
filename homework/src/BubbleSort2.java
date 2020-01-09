/**
 * @author LiSheng
 * @date 2020/1/9 16:36
 * 找出最大值对于的索引，最后一次再交换到数组的末端
 * 感觉变成了选择排序了。。。
 */
public class BubbleSort2 {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = 0;
            int j;
            for (j = 1; j < arr.length - i; j++) {
                if (arr[maxIndex].compareTo(arr[j]) < 0) {
                    maxIndex = j;
                }
            }
            if (maxIndex != j - 1) {
                swap(arr, maxIndex, j - 1);
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("BubbleSort", arr);

        arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("BubbleSort2", arr);
    }
}
