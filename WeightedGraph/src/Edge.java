/**
 * @author LiSheng
 * @date 2020/2/12 19:49
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {

    //边的两个端点
    private int a, b;
    //边的权值
    private Weight weight;

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge() {
    }

    public int v() {
        return a;
    }

    public int w() {
        return b;
    }

    public Weight wt() {
        return weight;
    }

    public int other(int x) {
        if (x == a || x == b) {
            return x == a ? b : a;
        }
        throw new IllegalArgumentException("x not equals a or b");
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight.compareTo(o.wt()) > 0) {
            return 1;
        } else if (this.weight.compareTo(o.wt()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return " " + a + "-" + b + "：" + weight;
    }
}
