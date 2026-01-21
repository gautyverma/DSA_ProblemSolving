package gfg.a17_Graph.course;

/*
* Edges shown:
0 — 1 (5)
0 — 2 (10)
1 — 2 (3)
1 — 3 (20)
2 — 3 (2)
* */

import gfg.a17_Graph.common.Edge;
import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class a12_DijkstraAlgo {
  public static void main(String[] args) {
    int[][] graph = new int[][] {{0, 5, 10, 0}, {5, 0, 3, 20}, {10, 3, 0, 2}, {0, 20, 2, 0}};
    System.out.println("1. Naive solution : " + naiveDijkstra(graph, 0));
    System.out.println("======");
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Edge>> adj = util.getWeightedUnDirectedGraph();
    util.printWeightedGraph(adj);
    System.out.println("2. Efficient approach using adj list and min-heap :" + effDijkstra(adj, 0));
  }

  private static ArrayList<Integer> naiveDijkstra(int[][] graph, int src) {
    int V = graph.length;
    Integer[] dist = new Integer[V];
    boolean[] fin = new boolean[V];
    // Initialize all keys as INFINITE
    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
      fin[i] = false;
    }
    dist[src] = 0;
    for (int count = 0; count < V - 1; count++) {
      int u = -1;
      for (int i = 0; i < V; i++) {
        if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
          u = i;
        }
      }
      fin[u] = true;
      for (int v = 0; v < V; v++) {
        if (!fin[v] && graph[u][v] != 0) {
          dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
        }
      }
    }
    return new ArrayList<>(Arrays.asList(dist));
  }
 // ==== Efficient solution ====
  // Pair class for PriorityQueue
  static class Pair {
    int v;
    int dist;

    Pair(int v, int dist) {
      this.v = v;
      this.dist = dist;
    }
  }

  private static ArrayList<Integer> effDijkstra(ArrayList<ArrayList<Edge>> adj, int src) {
    int V = adj.size();
    Integer[] dist = new Integer[V];
    int[] parent = new int[V];
    boolean[] visited = new boolean[V];

    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(parent, -1);

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

    dist[src] = 0;
    pq.add(new Pair(src, 0));
    while (!pq.isEmpty()) {

      Pair curr = pq.poll();
      int u = curr.v;

      if (visited[u]) continue;
      visited[u] = true;

      // Relaxation
      for (Edge e : adj.get(u)) {
        int v = e.v;
        int wt = e.weight;

        if (!visited[v] && dist[u] + wt < dist[v]) {
          dist[v] = dist[u] + wt;
          parent[v] = u;
          pq.add(new Pair(v, dist[v]));
        }
      }
    }

    printResult(dist, parent, src);
    return new ArrayList<>(Arrays.asList(dist));
  }

  // Print shortest distances and paths
  private static void printResult(Integer[] dist, int[] parent, int source) {

    System.out.println("Vertex\tDistance\tPath");

    for (int v = 0; v < dist.length; v++) {
      System.out.print(v + "\t\t" + dist[v] + "\t\t");
      printPath(parent, v, source);
      System.out.println();
    }
  }

  // Print path using parent[]
  private static void printPath(int[] parent, int v, int source) {

    if (v == source) {
      System.out.print(source);
      return;
    }

    Stack<Integer> stack = new Stack<>();
    int curr = v;

    while (curr != -1) {
      stack.push(curr);
      curr = parent[curr];
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
      if (!stack.isEmpty()) System.out.print(" -> ");
    }
  }
}
