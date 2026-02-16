package gfg.a17_Graph.exercise;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class a12_MotherVertex {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = util.getDirectedSSCGraph();
    System.out.println("Mother vertex :: " + motherVertex(adj.size(), adj));
  }

  private static int motherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    int lastV = 0;
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, adj);
        lastV = i;
      }
    }

    Arrays.fill(visited,false);
    dfs(lastV,visited,adj);
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        return -1;
      }
    }
    return lastV;
  }

  private static void dfs(int u, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    visited[u] = true;
    for (int v : adj.get(u)) {
      if (!visited[v]) {
        dfs(v, visited, adj);
      }
    }
  }
}
