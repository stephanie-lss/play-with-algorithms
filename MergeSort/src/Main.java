import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/1/9 21:43
 */
public class Main {
    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("MergeSort", arr);
        SortTestHelper.testSort("MergeSort2", arr2);
    }
}
