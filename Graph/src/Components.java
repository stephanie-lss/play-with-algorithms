/**
 * @author LiSheng
 * @date 2020/2/12 12:19
 */
public class Components {
    private Graph graph;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    public Components(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        this.id = new int[graph.V()];
        this.ccount = 0;

        for (int i = 0; i < graph.V(); i++) {
            id[i] = -1;
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (Integer i : graph.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public int count() {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        if (v < 0 || v >= graph.V() || w < 0 || w >= graph.V()) {
            throw new IllegalArgumentException("Error");
        }
        return id[v] == id[w];
    }
}
