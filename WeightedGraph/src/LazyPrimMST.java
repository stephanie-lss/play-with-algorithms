import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/13 10:27
 */
public class LazyPrimMST<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> graph;
    private MinHeap<Edge<Weight>> minHeap;
    private boolean[] marked;
    private List<Edge<Weight>> mst;
    private Weight weight;
    private double mstWeight;

    public LazyPrimMST(WeightedGraph<Weight> graph) {
        this.graph = graph;
        this.minHeap = new MinHeap<>(graph.E());
        this.marked = new boolean[graph.V()];
        this.mst = new ArrayList<>();


        //lazy Prim
        visit(0);
        while (!minHeap.isEmpty()) {
            Edge<Weight> e = minHeap.extractMin();
            if (marked[e.v()] == marked[e.w()]) {
                continue;
            }
            mst.add(e);
            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }
        mstWeight = mst.get(0).wt().doubleValue();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight + mst.get(i).wt().doubleValue();
        }
    }

    private void visit(int i) {
        if (!marked[i]) {
            marked[i] = true;
        }
        for (Edge<Weight> edge : this.graph.adj(i)) {
            if (!marked[edge.other(i)]) {
                minHeap.insert(edge);
            }
        }
    }

    public List<Edge<Weight>> mstEdges() {
        return mst;
    }

    public Double result() {
        return mstWeight;
    }
}
