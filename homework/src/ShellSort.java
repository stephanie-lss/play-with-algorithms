/**
 * @author LiSheng
 * @date 2020/1/9 18:36
 */
public class ShellSort {

    // 我们的算法类不允许产生任何实例
    private ShellSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        //增量
        int h = 1;

        while (h < n / 2) {
            h = h * 2 + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                Comparable e = arr[i];
                int j;
                for (j = i; j >= h ; j -= h) {
                    if (e.compareTo(arr[j - h]) < 0) {
                        arr[j] = arr[j - h];
                    } else {
                        break;
                    }
                }
                arr[j] = e;
            }
            h = h / 2;
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("ShellSort", arr);
    }
}
