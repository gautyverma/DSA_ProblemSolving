package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;
import java.util.*;

public class a4_ShortestPathInUnWeightedGraph {
  public static void main(String[] args) {
    OPS_Graph graph = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = graph.getUndirectedGraphShortest();
    graph.printGraph(adj);
    int source = 0;
    System.out.println(
        String.format("Shortest distance from source '%d' = ", source) + shortestPathDist(adj, source));

    System.out.println("========================");
    int V = adj.size();

    System.out.println("Shortest paths from source " + source + ":\n");
    for (int dest = 0; dest < V; dest++) {

      ArrayList<Integer> path = shortestPath(adj, source, dest);

      if (path.isEmpty()) {
        System.out.println(source + " -> " + dest + " : No path");
      } else {
        System.out.println(source + " -> " + dest + " : " + path);
      }
    }
  }

  private static ArrayList<Integer> shortestPathDist(ArrayList<ArrayList<Integer>> adj, int source) {

    int vertices = adj.size();
    Integer[] dist = new Integer[vertices];
    dist[source] = 0;

    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[vertices];
    q.add(source);
    visited[source] = true;

    while (!q.isEmpty()) {
      int u = q.poll();
      for (int v : adj.get(u)) {
        if (!visited[v]) {
          dist[v] = dist[u] + 1;
          visited[v] = true;
          q.add(v);
        }
      }
    }
    return new ArrayList<Integer>(Arrays.asList(dist));
  }

  private static ArrayList<Integer> shortestPath(
      ArrayList<ArrayList<Integer>> adj, int source, int dest) {

    int V = adj.size();

    boolean[] visited = new boolean[V];
    int[] parent = new int[V];
    Arrays.fill(parent, -1);

    Queue<Integer> q = new LinkedList<>();
    q.add(source);
    visited[source] = true;
    parent[source] = source;

    // BFS
    while (!q.isEmpty()) {
      int u = q.poll();

      for (int v : adj.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          parent[v] = u;
          q.add(v);

          if (v == dest) break; // optional early stop
        }
      }
    }

    // Build path
    ArrayList<Integer> path = new ArrayList<>();
    if (!visited[dest]) return path; // no path

    for (int v = dest; v != source; v = parent[v]) {
      path.add(v);
    }
    path.add(source);
    Collections.reverse(path);

    return path;
  }
}
