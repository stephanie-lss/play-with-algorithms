import java.util.*;

/**
 * @author LiSheng
 * @date 2020/2/12 16:04
 */
public class ShortestPath {
    private Graph graph;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    public ShortestPath(Graph graph, int s) {
        //算法初始化
        if (s < 0 && s >= graph.V()) {
            throw new IllegalArgumentException("Initial Error!");
        }

        this.visited = new boolean[graph.V()];
        this.from = new int[graph.V()];
        this.ord = new int[graph.V()];
        this.s = s;
        for (int i = 0; i < graph.V(); i++) {
            this.from[i] = -1;
            this.ord[i] = -1;
        }

        //无向图最短路径算法
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            for (Integer i : graph.adj(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    ord[i] = ord[v] + 1;
                    from[i] = v;
                }
            }
        }
    }

    public List<Integer> path(int w) {
        Stack<Integer> stack = new Stack<>();
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public boolean hasPath(int w, List<Integer> list) {
        if (w < 0 || w >= graph.V()) {
            throw new IllegalArgumentException("HasPath Error");
        }
        return visited[w];
    }

    public int length(int w) {
        return ord[w];
    }

    public void showPath(int w) {
        List<Integer> list = path(w);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " -> ");
            }
        }
    }
}
