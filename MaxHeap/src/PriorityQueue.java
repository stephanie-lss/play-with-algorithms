import java.util.Comparator;

/**
 * @author LiSheng
 * @date 2020/1/4 21:51
 */
public class PriorityQueue<E extends Comparable<E>>{
    private MaxHeap<E> maxHeap;
    private Comparator<E> comparator;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    public PriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void enqueue(E e) {
        maxHeap.add(e);
    }

    public E dequeue() {
        return maxHeap.extractMax();
    }

    public E getFront() {
        return maxHeap.findMax();
    }

    public int getSize() {
        return maxHeap.size();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
