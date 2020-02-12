/**
 * @author LiSheng
 * @date 2020/2/12 11:36
 */
public interface Graph {
    int V();

    int E();

    Iterable<Integer> adj(int v);

    boolean hasEdge(int v, int w);

    void addEdge(int v, int w);
}
