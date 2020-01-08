import java.util.Random;

public class SortTestHelper {

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt((rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
        return;
    }

    public static void testSort(String sortClassName, Comparable[] arr){
        Class<?> sortClass = Class.forName(sortClassName);

    }
}
