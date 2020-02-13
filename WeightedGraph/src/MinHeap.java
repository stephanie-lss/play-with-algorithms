/**
 * @author LiSheng
 * @date 2020/2/12 22:06
 */
public class MinHeap<Item extends Comparable> {
    private int count;
    private int capacity;
    private Item[] data;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.data = (Item[]) new Comparable[capacity + 1];
    }

    public MinHeap(Item[] arr) {
        data = (Item[]) new Comparable[capacity + 1];
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }
        int k = count / 2;
        while (k >= 1) {
            shiftDown(k);
            k--;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void insert(Item item) {
        if (count + 1 > capacity) {
            throw new IllegalArgumentException("Error");
        }
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public Item extractMin() {
        Item ret = data[1];
        swap(count, 1);
        count--;
        shiftDown(1);

        return ret;
    }

    private void shiftDown(int i) {
        while (2 * i <= count) {
            int j = 2 * i;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0) {
                j += 1;
            }
            if (data[i].compareTo(data[j]) <= 0) {
                break;
            }
            swap(i, j);
            i = j;
        }

    }

    private void shiftUp(int i) {
        while (i > 1 && data[i].compareTo(data[i / 2]) < 0) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    public Item getMin() {
        assert (count > 0);
        return data[1];
    }

    private void swap(int i, int j) {
        Item tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++) {
            minHeap.insert(new Integer((int) (Math.random() * M)));
        }

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for (int i = 1; i < N; i++) {
            assert arr[i - 1] <= arr[i];
        }
    }
}
