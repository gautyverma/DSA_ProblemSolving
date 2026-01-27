package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;
import java.util.ArrayList;
import java.util.Arrays;

public class a16_Bridges {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = util.getUndirectedArticulatedGraph();
    util.printGraph(adj);
    bridge(adj);
  }

  private static void bridge(ArrayList<ArrayList<Integer>> adj) {
    int V = adj.size();

    boolean[] visited = new boolean[V];
    int[] disc = new int[V];
    int[] low = new int[V];
    int[] parent = new int[V];

    Arrays.fill(parent, -1);

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfsBridge(i, adj, visited, disc, low, parent);
      }
    }
  }

  static int time = 0;

  private static void dfsBridge(
      int u,
      ArrayList<ArrayList<Integer>> adj,
      boolean[] visited,
      int[] disc,
      int[] low,
      int[] parent) {
    visited[u] = true;
    disc[u] = low[u] = ++time;
    for (int v : adj.get(u)) {
      if (!visited[v]) {
        parent[v] = u;
        dfsBridge(v, adj, visited, disc, low, parent);
        low[u] = Math.min(low[u], low[v]);
        // Bridge condition
        if (low[v] > disc[u]) {
          System.out.println("Bridge: " + u + " - " + v);
        }
      } else if (v != parent[u]) {
        low[u] = Math.min(low[u], disc[v]);
      }
    }
  }
}
