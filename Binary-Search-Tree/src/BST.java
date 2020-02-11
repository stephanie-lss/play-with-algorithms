/**
 * @author LiSheng
 * @date 2020/2/10 23:14
 */
public class BST<K extends Comparable<K>, V> {
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(K key, V value) {
        root = insert(key, value, root);
    }

    private Node insert(K key, V value, Node node) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) == 0) {
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(key, value, node.left);
        } else {
            node.right = insert(key, value, node.right);
        }
        return node;
    }
}
