/**
 * @author LiSheng
 * @date 2020/2/10 12:54
 */
public class IndexMaxHeap<Item extends Comparable> {
    private Item[] data;
    private Integer[] indexs;
    private int count;
    private int capacity;
    private Integer[] reverse;

    public IndexMaxHeap(int capacity) {
        data = (Item[]) new Object[capacity];
        indexs = new Integer[capacity + 1];
        count = 0;
        this.capacity = capacity;
        reverse = new Integer[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
    }

    public IndexMaxHeap(Item[] arr) {
        int n = arr.length;
        int k = n / 2;
        while (k >= 1) {
            siftDown(k);
            k--;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    //传入的i对用户而言，是从索引0开始的
    public void insert(int index, Item item) {
        if (count + 1 > capacity || index + 1 > capacity || index + 1 < 1) {
            throw new IllegalArgumentException("Error");
        }

        index += 1;
        data[index] = item;

        indexs[count + 1] = index;
        reverse[index] = count + 1;
        count++;
        siftUp(count);
    }

    private void siftUp(int i) {
        while (i > 1 && data[indexs[i / 2]].compareTo(data[indexs[i]]) < 0) {
            swap(indexs, i, i / 2);
            reverse[indexs[i / 2]] = i / 2;
            reverse[indexs[i]] = i;
            i = i / 2;
        }
    }

    public Item extractMax() {
        if (count <= 0) {
            throw new RuntimeException("Error!");
        }
        Item max = data[indexs[1]];

        swap(indexs, 1, count);
        reverse[indexs[1]] = 1;
        reverse[indexs[count]] = 0;
        count--;
        siftDown(1);

        return max;
    }

    public int extractMaxIndex() {
        if (count <= 0) {
            throw new RuntimeException("Error!");
        }
        int max = indexs[1] - 1;

        swap(indexs, 1, count);
        reverse[indexs[1]] = 1;
        reverse[indexs[count]] = 0;
        count--;
        siftDown(1);

        return max;
    }

    public Item getItem(int index) {
        assert contain(index);
        return data[index + 1];
    }

    public void change(int i, Item newItem) {

        assert contain(i);
        i += 1;

        data[i] = newItem;

        //找到indexes[j]=i,j表示data[i]在堆中的位置
        //之后siftUp(j),在siftDown(j)

        /*for (int j = 1; j <= count; j++) {
            if (indexs[j] == i) {
                siftUp(j);
                siftDown(j);
                return;
            }
        }*/
        int j = reverse[i];
        siftUp(j);
        siftDown(j);
    }

    private boolean contain(int i) {
        assert (i + 1 >= 1 && i + 1 <= capacity);
        return reverse[i + 1] != 0;
    }


    private void siftDown(int i) {
        while (i * 2 <= count) {
            int j = 2 * i;
            if (j + 1 <= count && data[indexs[j + 1]].compareTo(data[indexs[j]]) > 0) {
                j += 1;
            }
            if (data[indexs[i]].compareTo(data[indexs[j]]) >= 0) {
                break;
            }
            swap(indexs, i, j);
            reverse[indexs[i]] = i;
            reverse[indexs[j]] = j;
            i = j;
        }
    }

    private void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
