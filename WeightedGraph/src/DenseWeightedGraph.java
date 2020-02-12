import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/11 23:11
 * 稠密图——邻接矩阵
 */
public class DenseWeightedGraph<Weight extends Number & Comparable>
        implements WeightedGraph {    //n为顶点数，m为边数
    private int n, m;
    //是否为有向图
    private boolean directed;
    //邻接矩阵
    public Edge<Weight>[][] g;

    public DenseWeightedGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        if (e.v() < 0 || e.v() >= n || e.w() < 0 || e.w() >= n) {
            throw new IllegalArgumentException("Error");
        }
        if (hasEdge(e.v(), e.w())) {
            return;
        }
        g[e.v()][e.w()] = new Edge(e);
        if (e.v() != e.w() && !directed) {
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
        }
        m++;
    }


    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IllegalArgumentException("Error");
        }
        return !(g[v][w] == null);
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        if (v < 0 || v >= n) {
            throw new IllegalArgumentException("Error");
        }
        List<Edge<Weight>> adjV = new ArrayList<>();
        for (int w = 0; w < n; w++) {
            if (g[v][w] != null) {
                adjV.add(g[v][w]);
            }
        }
        return adjV;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + "：");
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].wt() + "    ");
                } else {
                    System.out.print("NULL    ");
                }
            }
            System.out.println();
        }
    }
}
