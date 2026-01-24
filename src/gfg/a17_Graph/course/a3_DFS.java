package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;

public class a3_DFS {
  public static void main(String[] args) {
    OPS_Graph graph = new OPS_Graph();
    ArrayList<ArrayList<Integer>> graph1 = graph.getUndirectedGraph();
    graph.printGraph(graph1);
    System.out.println("------------");
    System.out.println("DFS undirected -> " + dfs1(graph1, 0));
    System.out.println("------------");

    ArrayList<ArrayList<Integer>> graph2 = graph.getMultiUndirectedGraph();
    graph.printGraph(graph2);
    System.out.println("------------");
    System.out.println("DFS undirected disconnected graph -> " + dfs2(graph2));
    System.out.println("------------");
  }

  private static ArrayList<Integer> dfs2(ArrayList<ArrayList<Integer>> graph) {
    int vertices = graph.size();
    boolean[] visited = new boolean[vertices];
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
      if (!visited[i]) dfsRec(graph, i, visited, res);
    }
    return res;
  }

  private static ArrayList<Integer> dfs1(ArrayList<ArrayList<Integer>> graph, int src) {
    int vertices = graph.size();
    boolean[] visited = new boolean[vertices];
    ArrayList<Integer> res = new ArrayList<>();
    dfsRec(graph, src, visited, res);
    return res;
  }

  /*
Input the adjacency list of the graph and the source vertex.
Create a boolean array visited[] of size equal to the number of vertices and initialize all values to false.
Create an empty list to store the DFS traversal.
Call the recursive DFS function with source vertex.
In the DFS recursive function:
  a. Mark the current vertex as visited.
  b. Add the current vertex to the traversal list.
  c. For each adjacent vertex of the current vertex:
    i. If the adjacent vertex is not visited:
      - Recursively call DFS for that vertex.

Continue until all reachable vertices from the source are visited.

Output the traversal list.
  * */
  private static void dfsRec(
      ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, ArrayList<Integer> res) {
    visited[src] = true;
    //    System.out.print(src + " ");
    res.add(src);
    for (int u : adj.get(src)) {
      if (!visited[u]) dfsRec(adj, u, visited, res);
    }
  }
}
