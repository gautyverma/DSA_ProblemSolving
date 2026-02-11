package gfg.a17_Graph.exercise;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;

public class a9_PossiblePathsBtwSrcDest {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = util.getDirectedAcyclicGraph();
    System.out.println("Possible paths :: " + countPaths(adj.size(), adj, 0, 3));
  }

  private static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int src, int dest) {

    if (src == dest) return 1;
    int totalPaths = 0;

    for (int neighbor : adj.get(src)) totalPaths += countPaths(V, adj, neighbor, dest);
    return totalPaths;
  }
}
