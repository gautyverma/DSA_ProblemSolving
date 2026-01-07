package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;

public class a6_DetectCycleDirectedGraph {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = util.getDirectedGraphCyclic();
    util.printGraph(adj);
    System.out.println("-------------------");
    System.out.println("Is Cycle present :" + isCyclicDirectGraph(adj));
    System.out.println("-------------------");
  }

  private static boolean isCyclicDirectGraph(ArrayList<ArrayList<Integer>> adj) {
    int vertices = adj.size();
    boolean[] visited = new boolean[vertices];
    boolean[] recStack = new boolean[vertices];

    for (int i = 0; i < vertices; i++) {
      if (!visited[i]) if (dfsRecUtil(adj, i, visited, recStack)) return true;
    }
    return false;
  }

  private static boolean dfsRecUtil(
      ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, boolean[] recStack) {
    visited[src] = true;
    recStack[src] = true;
    for (int u : adj.get(src)) {
      if (!visited[u] && dfsRecUtil(adj, u, visited, recStack)) return true;
      else if (recStack[u]) {
        return true;
      }
    }
    recStack[src] = false;
    return false;
  }
}
