import java.util.LinkedList;
import java.util.Queue;

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

    public boolean contain(K key) {
        return contain(key, root);
    }

    private boolean contain(K key, Node node) {
        if (node == null) {
            return false;
        }
        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (node.key.compareTo(key) > 0) {
            return contain(key, node.left);
        } else {
            return contain(key, node.right);
        }
    }

    public V search(K key) {
        return search(key, root);
    }

    private V search(K key, Node node) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(key, node.left);
        } else {
            return search(key, node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public K minimum() {
        if (count != 0) {
            Node node = minimum(root);
            return node.key;
        }
        return null;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public K maximum() {
        if (count != 0) {
            Node node = maximum(root);
            return node.key;
        }
        return null;
    }

    private Node maximum(Node node) {
        if (node == null) {
            return null;
        }
        return maximum(node.right);
    }

    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(K key) {
        if (root != null) {
            root = remove(key, root);
        }
    }

    private Node remove(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            count++;
            successor.left = node.left;
            node.left = null;
            node.right = null;
            count--;
            return successor;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(key, node.right);
            return node;
        } else {
            node.left = remove(key, node.left);
            return node;
        }
    }

}
