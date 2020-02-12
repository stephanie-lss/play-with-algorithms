import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/11 23:11
 * 稠密图——邻接矩阵
 */
public class DenseGraph implements Graph {
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

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
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

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IllegalArgumentException("Error");
        }
        return g[v][w];
    }

    @Override
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

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + "：");
            for (int j = 0; j < n; j++) {
                System.out.print(g[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
