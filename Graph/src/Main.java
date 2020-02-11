import java.util.Iterator;
import java.util.Random;

/**
 * @author LiSheng
 * @date 2020/2/11 23:56
 */
public class Main {
    public static void main(String[] args) {
        int N = 20;
        int M = 100;
        //Sparse Graph
        SparseGraph sparseGraph = new SparseGraph(N, false);
        Random random = new Random();
        for (int i = 0; i < M; i++) {
            int a = random.nextInt(N);
            int b = random.nextInt(N);
            sparseGraph.addEdge(a, b);
        }
        for (int v = 0; v < N; v++) {
            Iterator<Integer> iterator = sparseGraph.adj(v).iterator();
            System.out.print(v + "：");
            while (iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }

        System.out.println("*********");
        //Dense Graph
        DenseGraph denseGraph = new DenseGraph(N, false);
        for (int i = 0; i < M; i++) {
            int a = random.nextInt(N);
            int b = random.nextInt(N);
            denseGraph.addEdge(a, b);
        }
        for (int v = 0; v < N; v++) {
            Iterator<Integer> iterator = denseGraph.adj(v).iterator();
            System.out.print(v + "：");
            while (iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }
}
