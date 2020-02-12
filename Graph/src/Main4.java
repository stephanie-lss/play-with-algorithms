public class Main4 {

    // 测试寻路算法
    public static void main(String[] args) {

        String filename = "G:\\GitHub\\play-with-algorithms\\Graph\\testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        System.out.print("DFS：");
        path.showPath(6);

        System.out.println();

        ShortestPath shortestPath = new ShortestPath(g, 0);
        System.out.println("ShortestPath from 0 to 6 ：");
        System.out.print("BFS：");
        shortestPath.showPath(6);

    }
}
