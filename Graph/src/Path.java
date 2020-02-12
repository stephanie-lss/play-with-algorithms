import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/2/12 12:44
 */
public class Path {
    private Graph graph;
    private int s;
    private boolean[] visited;
    private int[] from;

    public Path(Graph graph, int s) {
        assert (s >= 0 && s < graph.V());
        this.graph = graph;
        this.s = s;
        this.visited = new boolean[graph.V()];
        this.from = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            from[i] = -1;
        }

        //寻路算法
        dfs(s);
    }

    private void dfs(int s) {
        if (s < 0 || s >= graph.V()) {
            throw new IllegalArgumentException("Error");
        }
        visited[s] = true;
        for (Integer i : graph.adj(s)) {
            if (!visited[i]) {
                from[i] = s;
                dfs(i);
            }
        }
    }

    public boolean hasPath(int w) {
        if (w < 0 || w >= graph.V()) {
            throw new IllegalArgumentException("Error");
        }
        return visited[w];
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
