package Graph.connectedComponents;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
 */
public class ConnectedComponentsInAnUndirectedGraph {


    public static void connectedComponents(Graph g) {
        int V = g.getV();
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, g);
                System.out.println();
            }
        }
    }

    // 或者把计算连通性的方法放在图的类里面
//    Graph graph;
//    public void dfs(int v, boolean[] visited) {
//        visited[v] = true;
//        System.out.println(v);
//
//        for (Integer w : graph.adj(v)) {
//            if (visited[w] == false) dfs(w, visited);
//        }
//    }

    static boolean[] visited;
    public static void dfs(int s, Graph g) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int v : g.adj(s)) {
            if (!visited[v]) dfs(v, g);
        }
    }

    public static void main(String[] args) {

        // Create a graph given in the above diagram
        Graph g = new Graph(5); // 5 vertices numbered from 0 to 4
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);



        System.out.println("Following are connected components \n");
        connectedComponents(g);
    }
}

class Graph {
    private int V;
    private List<List<Integer>> graph = new ArrayList<>();

    public Graph(int v) {
        V = v;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }


    public List<Integer> adj(int v) {
        return graph.get(v);
    }

    public void addEdge(int v, int w) {
        graph.get(v).add(w);
        graph.get(w).add(v);
    }

    public int getV() {
        return V;
    }
}