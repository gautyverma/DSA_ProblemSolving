package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;
import java.util.ArrayList;
import java.util.Arrays;

public class a15_ArticulationPoint {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = util.getUndirectedArticulatedGraph();
    util.printGraph(adj);
    System.out.println("Articulation points : " + articulationPoints(adj));
  }

  private static ArrayList<Integer> articulationPoints(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res = new ArrayList<>();
    int V = adj.size();

    boolean[] visited = new boolean[V];
    int[] disc = new int[V];
    int[] low = new int[V];
    int[] parent = new int[V];
    boolean[] isAP = new boolean[V];

    Arrays.fill(parent, -1);

    for (int i = 0; i < V; i++) {
      if (!visited[i]) dfs(i, adj, visited, disc, low, parent, isAP);
    }
    for (int i = 0; i < V; i++) {
      if (isAP[i])
        //        System.out.println(i);
        res.add(i);
    }
    return res;
  }

  static int time = 0;

  private static void dfs(
      int u,
      ArrayList<ArrayList<Integer>> adj,
      boolean[] visited,
      int[] disc,
      int[] low,
      int[] parent,
      boolean[] isAP) {
    visited[u] = true;
    disc[u] = low[u] = ++time;

    int children = 0;
    for (int v : adj.get(u)) {
      // Tree edge
      if (!visited[v]) {
        children++;
        parent[v] = u;

        dfs(v, adj, visited, disc, low, parent, isAP);

        low[u] = Math.min(low[u], low[v]);

        // Root case
        if (parent[u] == -1 && children > 1) isAP[u] = true;

        // Non-root case
        if (parent[u] != -1 && low[v] >= disc[u]) isAP[u] = true;
      }

      // Back edge
      else if (v != parent[u]) {
        low[u] = Math.min(low[u], disc[v]);
      }
    }
  }
}
