/**
 * @author LiSheng
 * @date 2020/2/10 18:11
 */
public class BinarySearch {

    public static int binarySearchNR(Comparable[] arr, Comparable target) {
        int n = arr.length;
        //在arr[l...r]之中查找target
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(Comparable[] arr, Comparable target) {
        int n = arr.length;
        //在arr[l...r]之中查找target

        int l = 0, r = n - 1;
        return merge(arr, target, l, r);
    }

    private static int merge(Comparable[] arr, Comparable target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (target.compareTo(arr[mid]) == 0) {
            return mid;
        }

        if (target.compareTo(arr[mid]) > 0) {
            return merge(arr, target, mid + 1, r);
        } else {
            return merge(arr, target, l, mid - 1);
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        int i = BinarySearch.binarySearchNR(arr, 7);
        System.out.println(i);
    }
}




