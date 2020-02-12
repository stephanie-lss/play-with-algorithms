import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/11 23:24
 * 稀疏图——邻接表
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n, m;
    private boolean directed;
    private List<Edge<Weight>>[] g;

    public SparseWeightedGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
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
        g[e.v()].add(new Edge(e));
        if (e.v() != e.w() && !directed) {
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IllegalArgumentException("Error");
        }
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    //返回图中一个顶点的所以邻边
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        if (v < 0 || v >= n) {
            throw new IllegalArgumentException("Error");
        }
        return g[v];
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            Iterator<Edge<Weight>> iterator = g[i].iterator();
            System.out.print("vertex " + i + "：");
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + "\t");
            }
            System.out.println();
        }
    }
}
