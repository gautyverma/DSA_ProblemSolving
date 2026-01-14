package gfg.a17_Graph.course;

import gfg.a17_Graph.common.Edge;
import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class a10_ShortestPath {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Edge>> weightedDirectedAcyclicGraph =
        util.getWeightedDirectedAcyclicGraph();
    util.printWeightedGraph(weightedDirectedAcyclicGraph);
    int source = 0;
    System.out.println("----------------");
    System.out.println(
        "Shortest path from given source '"
            + source
            + "' : "
            + shortestPathFromSource(weightedDirectedAcyclicGraph, source));
    System.out.println("----------------");
  }

  private static ArrayList<Integer> shortestPathFromSource(
      ArrayList<ArrayList<Edge>> adj, int src) {
    int V = adj.size();

    // Topological Sort using DFS
    boolean[] visited = new boolean[V];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < V; i++) {
      if (!visited[i]) dfs(i, visited, adj, st);
    }

    // Initialize distances
    Integer[] dist = new Integer[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    while (!st.isEmpty()) {
      int u = st.pop();
      if (dist[u] != Integer.MAX_VALUE) {
        for (Edge e : adj.get(u)) {
          if (dist[e.v] > dist[u] + e.weight) {
            dist[e.v] = dist[u] + e.weight;
          }
        }
      }
    }
    return new ArrayList<>(Arrays.asList(dist));
  }

  private static void dfs(
      int u, boolean[] visited, ArrayList<ArrayList<Edge>> adj, Stack<Integer> st) {
    visited[u] = true;
    for (Edge e : adj.get(u)) {
      if (!visited[e.v]) {
        dfs(e.v, visited, adj, st);
      }
    }
    st.add(u);
  }
}
