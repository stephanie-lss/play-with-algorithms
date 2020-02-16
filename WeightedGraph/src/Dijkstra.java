import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/2/14 10:04
 */
public class Dijkstra<Weight extends Number & Comparable> {
    private WeightedGraph graph;
    private int s;
    private Number[] distTo;
    private boolean[] marked;
    private Edge<Weight>[] from;

    public Dijkstra(WeightedGraph graph, int s) {
        this.graph = graph;
        this.s = s;
        this.distTo = new Number[graph.V()];
        this.marked = new boolean[graph.V()];
        this.from = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = 0.0;
            from[i] = null;
        }
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(graph.V());

        //Dijkstra
        distTo[s] = 0.0;
        marked[s] = true;

        //Relaxation
        ipq.insert(s, (Weight) distTo[s]);
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            //distTo[v]就是s到v的最短距离
            marked[v] = true;
            for (Object e : graph.adj(v)) {
                Edge<Weight> edge = (Edge<Weight>) e;
                int w = edge.other(v);
                if (!marked[w]) {
                    if (from[w] == null || distTo[v].doubleValue() + edge.wt().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + edge.wt().doubleValue();
                        from[w] = edge;
                        if (ipq.contain(w)) {
                            ipq.change(w, (Weight) distTo[w]);
                        } else {
                            ipq.insert(w, (Weight) distTo[w]);
                        }
                    }
                }
            }
        }
    }

    public Number shortestPathTo(int w) {
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public List<Edge<Weight>> shortestPath(int w) {
        assert (w >= 0 && w < graph.V());
        assert (hasPathTo(w));
        Stack<Edge<Weight>> stack = new Stack<>();
        Edge<Weight> edge = from[w];
        while (edge.v() != this.s) {
            stack.push(edge);
            edge = from[edge.v()];
        }
        stack.push(edge);
        List<Edge<Weight>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public void showPath(int w) {
        if (w >= 0 && w < graph.V()) {
            List<Edge<Weight>> list = shortestPath(w);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).v() + " -> ");
                if (i == list.size() - 1) {
                    System.out.print(list.get(i).w());
                }
            }
        }
    }
}
