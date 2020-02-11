import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/11 23:11
 * 稠密图——邻接矩阵
 */
public class DenseGraph {
    //n为顶点数，m为边数
    private int n, m;
    //是否为有向图
    private boolean directed;
    //邻接矩阵
    public boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new boolean[n][n];
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
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IllegalArgumentException("Error");
        }
        return g[v][w];
    }

    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= n) {
            throw new IllegalArgumentException("Error");
        }
        List<Integer> adjV = new ArrayList<>();
        for (int w = 0; w < n; w++) {
            if (g[v][w]) {
                adjV.add(w);
            }
        }
        return adjV;
    }
}
