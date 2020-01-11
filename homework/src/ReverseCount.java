/**
 * @author LiSheng
 * @date 2020/1/11 12:44
 */
public class ReverseCount {
    public static int size = 0;

    public static void sort(Comparable[] arr) {
        int n = arr.length - 1;
        mergeSort(arr, 0, n);
    }

    private static void mergeSort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] temp = new Comparable[r - l + 1];
        int m = mid + 1;
        int k = 0;
        int i = l;
        int count = 0;
        while (i <= mid && m <= r) {
            if (arr[i].compareTo(arr[m]) > 0) {
                temp[k] = arr[m];
                k++;
                m++;
                count += (mid - i + 1);
            } else {
                temp[k] = arr[i];
                k++;
                i++;
            }
        }
        if (i != mid + 1) {
            //arr[l...mid]还有剩余
            for (int t = i; t <= mid; t++) {
                temp[k++] = arr[t];
            }
        }
        if (m != r + 1) {
            //arr[m...r]还有剩余
            for (int t = m; t <= r; t++) {
                temp[k++] = arr[t];
            }
        }
        for (int t = 0; t < temp.length; t++) {
            arr[l + t] = temp[t];
        }
        size += count;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        for (Integer a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        sort(arr);
        for (Integer a : arr) {
            System.out.print(a + " ");
        }

        System.out.println("count:"+size);
    }
}
