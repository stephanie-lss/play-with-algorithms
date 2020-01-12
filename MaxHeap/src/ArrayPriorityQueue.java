/**
 * @author LiSheng
 * @date 2020/1/5 12:23
 */
public class ArrayPriorityQueue<E> {
    private Array<E> array;
    private int size;

    public ArrayPriorityQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayPriorityQueue() {
        array = new Array<>();
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.getFirst();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
