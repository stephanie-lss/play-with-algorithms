/**
 * @author LiSheng
 * @date 2020/1/9 21:24
 */
public class MergeSort2 {

    public static void sort(Comparable[] arr) {
        int n = arr.length - 1;
        mergeSort(arr, 0, n);
    }

    private static void mergeSort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Comparable[] arr, int left, int mid, int right) {
        Comparable[] tmp = new Comparable[right - left + 1];
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i].compareTo(arr[j]) < 0) {
                tmp[k] = arr[i];
                k++;
                i++;
            } else if (arr[i].compareTo(arr[j]) > 0) {
                tmp[k] = arr[j];
                k++;
                j++;
            } else {
                tmp[k] = arr[i];
                k++;
                i++;
                tmp[k] = arr[j];
                k++;
                j++;
            }
        }
        if (i != mid + 1) {
            for (int l = i; l <= mid; l++) {
                tmp[k] = arr[l];
                k++;
            }
        }
        if (j != right + 1) {
            for (int l = j; l <= right; l++) {
                tmp[k] = arr[l];
                k++;
            }
        }
        for (int l = 0; l < tmp.length; l++) {
            arr[left + l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("MergeSort2",arr);

    }
}
