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
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Comparable[] arr, int left, int mid, int right) {
        Comparable[] aux = Arrays.copyOfRange(arr, left, right + 1);
        int i = left;
        int j = mid + 1;
//        int k = left;
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
        /*while (i <= mid && j <= right) {
            if (aux[i - left].compareTo(aux[j - left]) < 0) {
                arr[k] = aux[i - left];
                i++;
                k++;
            } else if (aux[i - left].compareTo(aux[j - left]) > 0) {
                arr[k] = aux[j - left];
                j++;
                k++;
            } else {
                arr[k] = aux[i - left];
                i++;
                k++;
                arr[k] = aux[j - left];
                j++;
                k++;
            }
        }
        if (i != mid + 1) {
            for (int l = i; l <= mid; l++) {
                arr[k] = aux[l - left];
                k++;
            }
        }
        if (j != right + 1) {
            for (int l = j; l <= right; l++) {
                arr[k] = aux[l - left];
                k++;
            }
        }*/
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
