/**
 * @author LiSheng
 * @date 2020/2/13 11:35
 */
public class IndexMinHeap<Item extends Comparable> {
    private Item[] data;    //最小索引堆中的数据
    private int[] indexes;  //最小索引堆中的索引，indexes[x]
    private int[] reverse;
    private int count;
    private int capacity;

    public IndexMinHeap(int capacity) {
        this.capacity = capacity;
        this.data = (Item[]) new Comparable[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.reverse = new int[capacity + 1];
        for (int i = 0; i < capacity + 1; i++) {
            reverse[i] = 0;
        }
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void insert(int i, Item item){

        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(i);

        i += 1;
        data[i] = item;
        indexes[count+1] = i;
        reverse[i] = count + 1;
        count ++;

        shiftUp(count);
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k]].compareTo(data[indexes[k / 2]]) < 0) {
            swapIndexes(k, k / 2);
            k = k / 2;
        }
    }

    private void swapIndexes(int i, int j) {
        int tmp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = tmp;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    public boolean contain(int i) {
        return reverse[i + 1] != 0;
    }

    public Item getItem(int i) {
        if (contain(i)) {
            return data[i + 1];
        }
        return null;
    }

    public int extractMinIndex() {
        if (count > 0) {
            int ret = indexes[1] - 1;
            swapIndexes(1, count);
            reverse[indexes[count]] = 0;
            count--;
            shiftDown(1);
            return ret;
        }
        return -1;
    }

    public void change(int i, Item newItem) {
        if (contain(i)) {
            i += 1;
            data[i] = newItem;

            shiftUp(reverse[i]);
            shiftDown(reverse[i]);
        }
    }

    private void shiftDown(int i) {
        if (contain(i)) {
            while (2 * i <= count) {
                int j = i * 2;
                if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) < 0) {
                    j += 1;
                }
                if (data[indexes[i]].compareTo(data[indexes[j]]) <= 0) {
                    break;
                }
                swapIndexes(i, j);
                i = j;
            }
        }
    }

    // 测试 IndexMinHeap
    public static void main(String[] args) {

        int N = 1000000;
        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<Integer>(N);
        for (int i = 0; i < N; i++) {
            indexMinHeap.insert(i, (int) (Math.random() * N));
        }
    }
}
