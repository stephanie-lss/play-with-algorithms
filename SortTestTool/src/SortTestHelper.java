import java.lang.reflect.Method;
import java.util.Random;

public class SortTestHelper {
    public SortTestHelper() {
    }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt((rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
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

    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);
            if (isSorted(arr)) {
                /*for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }*/
                System.out.println();
                System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
            } else {
                System.out.println(sortClass.getSimpleName() + " failure!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
