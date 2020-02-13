import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/13 12:27
 */
public class PrimMST<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> graph;
    private IndexMinHeap<Weight> minHeap;
    private Edge<Weight>[] edgeTo;
    private boolean[] marked;
    private List<Edge<Weight>> mst;
    private double weight;

    public PrimMST(WeightedGraph graph) {
        this.graph = graph;
        this.minHeap = new IndexMinHeap<>(graph.V());
        this.marked = new boolean[graph.V()];
        this.edgeTo = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            edgeTo[i] = null;
        }
        mst = new ArrayList<>();

        visit(0);
        while (!minHeap.isEmpty()) {
            int v = minHeap.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }
        weight = mst.get(0).wt().doubleValue();
        for (int i = 0; i < mst.size(); i++) {
            weight += mst.get(i).wt().doubleValue();
        }
    }

    private void visit(int v) {
        assert (!marked[v]);
        marked[v] = true;
        for (Object item : graph.adj(v)) {
            Edge<Weight> e = (Edge<Weight>) item;
            int w = e.other(v);
            // 如果边的另一端点未被访问
            if (!marked[w]) {
                // 如果从没有考虑过这个端点, 直接将这个端点和与之相连接的边加入索引堆
                if (edgeTo[w] == null) {
                    edgeTo[w] = e;
                    minHeap.insert(w, e.wt());
                }
                // 如果曾经考虑这个端点, 但现在的边比之前考虑的边更短, 则进行替换
                else if (e.wt().compareTo(edgeTo[w].wt()) < 0) {
                    edgeTo[w] = e;
                    minHeap.change(w, e.wt());
                }
            }
        }
    }

    public double result() {
        return weight;
    }
}
