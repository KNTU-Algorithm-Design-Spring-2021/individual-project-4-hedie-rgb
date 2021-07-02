import java.util.*;

public class Algorithm {

    private static int V;

    public static void setV(int v) {
        Algorithm.V = v;
    }

    private static boolean bfs(int rGraph[][], int s,
                       int t, int parent[]) {

        boolean[] visited = new boolean[V];


        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.peek();
            q.remove();

            for (int v = 0; v < V; v++) {
                if (!visited[v] &&
                        rGraph[u][v] > 0) {
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return (visited[t]);
    }

    static int findDisjointPaths(int[][] graph, int s, int t) {
        int u, v;

        int[][] rGraph = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];



        int[] parent = new int[V];

        int max_flow = 0;

        while (bfs(rGraph, s, t, parent)) {

            int path_flow = Integer.MAX_VALUE;

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            ArrayList<Integer> path = new ArrayList<>();
            ArrayList<Integer> pt = new ArrayList<>();

            for(int i = 0 ; i < V ; i ++) {
                path.add(parent[i]);
            }
            for (int p=1 ; p <V-1 ; p++) {
                if (graph[parent[p]][p] == 1 && path.contains(p) ) {
                    int l = path.indexOf(p);
                    if (path.contains(l)){
                        if (pt.contains(parent[p])) {
                            System.out.print(p+"->");
                        } else {
                            System.out.print(parent[p]+"->"+p+"->");
                            pt.add(parent[p]);
                        }
                        pt.add(p);
                    }
                }
            }
            int dest = V-1;
            System.out.print(parent[V-1] + "->" + dest+"\n");
            max_flow += path_flow;
        }
        return max_flow;
    }
}
