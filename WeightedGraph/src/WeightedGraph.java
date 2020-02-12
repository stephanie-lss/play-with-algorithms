/**
 * @author LiSheng
 * @date 2020/2/12 19:51
 */
interface WeightedGraph<Weight extends Number & Comparable> {
    int V();

    int E();

    void addEdge(Edge<Weight> e);

    Iterable<Edge<Weight>> adj(int v);

    boolean hasEdge(int v, int w);

    void show();
}
