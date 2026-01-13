package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.Stack;

public class a9_TopologicalSortUsingDFS {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> acyclicGraph = util.getDirectedAcyclicGraph();
    util.printGraph(acyclicGraph);
    System.out.println("Topological sort using DFS : " + topologicalSortDFS(acyclicGraph));
  }

  private static ArrayList<Integer> topologicalSortDFS(ArrayList<ArrayList<Integer>> adj) {
    int V = adj.size();
    boolean[] visited = new boolean[V];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, adj, st);
      }
    }
    ArrayList<Integer> res = new ArrayList<>();
    while (!st.isEmpty()) {
      res.add(st.pop());
    }
    return res;
  }

  private static void dfs(
      int u, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
    visited[u] = true;
    for (int v : adj.get(u)) {
      if (!visited[v]) {
        dfs(v, visited, adj, st);
      }
    }
    st.add(u);
  }
}
