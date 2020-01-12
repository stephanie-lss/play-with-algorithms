/**
 * @author LiSheng
 * @date 2020/1/12 17:33
 */
public class HeapSort1 {

    public static void sort(Integer[] arr) {
        int n = arr.length;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        /*for (int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
        }*/
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("HeapSort1", arr);
    }
}
