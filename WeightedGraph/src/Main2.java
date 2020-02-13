import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        String filename = "G:\\GitHub\\play-with-algorithms\\WeightedGraph\\testG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        List<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for (Edge<Double> doubleEdge : mst) {
            System.out.println(doubleEdge);
        }
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
