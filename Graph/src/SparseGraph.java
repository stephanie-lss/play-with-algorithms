import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/11 23:24
 * 稀疏图——邻接表
 */
public class SparseGraph {
    private int n, m;
    private boolean directed;
    private List<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IllegalArgumentException("Error");
        }
        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IllegalArgumentException("Error");
        }
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i) == w) {
                return true;
            }
        }
        return false;
    }

    //返回图中一个顶点的所以邻边
    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= n) {
            throw new IllegalArgumentException("Error");
        }
        return g[v];
    }
}
