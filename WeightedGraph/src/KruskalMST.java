import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/13 16:32
 */
public class KruskalMST<Weight extends Number & Comparable> {
    //保存最小生成树
    private List<Edge<Weight>> mst;
    //最小生成树的总权重
    private double mstWeight;
    //带权图的引用
    private WeightedGraph<Weight> graph;

    //构造函数初始化
    public KruskalMST(WeightedGraph<Weight> graph) {
        this.graph = graph;
        //初始化容器
        this.mst = new ArrayList<>();
        //初始化最小堆，保存两点之间的边的权重，容量为图总的边的数目
        MinHeap<Edge<Weight>> pq = new MinHeap<>(graph.E());
        //依次遍历所有的点
        for (int i = 0; i < graph.V(); i++) {
            //每个点的所有邻边
            for (Edge<Weight> edge : graph.adj(i)) {
                //因为是无向图，所以插入的时候为了防止重复插入（v-w，w-v）
                if (edge.v() <= edge.w()) {
                    pq.insert(edge);
                }
            }
        }
        //此时所有边均插入到最小堆中了，总共V-1个条边，依次取出堆顶的元素（堆排序）

        //初始化并查集
        UnionFind unionFind = new UnionFind(graph.V());
        //迭代终止条件：最小堆为空或者让最小生成树集合中的边数为大于等于V-1,
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {

            //取出堆顶元素
            Edge<Weight> e = pq.extractMin();
            //检查这条边对应的两个顶点是否已经连接，防止出现环
            if (unionFind.isConnected(e.v(), e.w())) {
                continue;
            }

            //未连接，添加进最小生成树中
            mst.add(e);
            //通过并查集设置两顶点已连接
            unionFind.unionElements(e.v(), e.w());
        }

        //计算最小生成树的总权重
        mstWeight = mst.get(0).wt().doubleValue();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight += mst.get(i).wt().doubleValue();
        }
    }

    public static void main(String[] args) {

        String filename = "G:\\GitHub\\play-with-algorithms\\WeightedGraph\\testG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Kruskal
        System.out.println("Test Kruskal:");
        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g);
        List<Edge<Double>> mst = kruskalMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
        System.out.println("The MST weight is: " + kruskalMST.result());

        System.out.println();
    }

    private double result() {
        return mstWeight;
    }

    private List<Edge<Weight>> mstEdges() {
        return mst;
    }
}
