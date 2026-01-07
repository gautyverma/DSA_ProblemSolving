package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;

public class a5_DetectCycleUndirectedGraph {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> graph = util.getUndirectedGraph();
    System.out.println("Is Cycle present :" + isCyclicGraph(graph));
  }

  private static boolean isCyclicGraph(ArrayList<ArrayList<Integer>> adj) {
    int vertices = adj.size();
    boolean[] visited = new boolean[vertices];
    for (int i = 0; i < vertices; i++) {
      if (!visited[i]) {
        if (dfsRec(adj, i, visited, -1)) return true;
      }
    }
    return false;
  }

  private static boolean dfsRec(
      ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, int parent) {
    visited[src] = true;
    for (int u : adj.get(src)) {
      if (!visited[u]) {
        if (dfsRec(adj, u, visited, src)) return true;
      } else if (u != parent) {
        return true;
      }
    }
    return false;
  }
}
