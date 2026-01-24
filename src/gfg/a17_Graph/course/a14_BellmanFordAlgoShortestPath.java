package gfg.a17_Graph.course;

import java.util.ArrayList;
import java.util.Arrays;

public class a14_BellmanFordAlgoShortestPath {
  static class Edge {
    int u, v, wt;

    Edge(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }
  }

  public static void main(String[] args) {
    ArrayList<Edge> edges = new ArrayList<>();
    int V = 4;
    int src = 0;
    edges.add(new Edge(0, 1, 1));
    edges.add(new Edge(0, 2, 4));

    edges.add(new Edge(1, 2, -3));

    edges.add(new Edge(1, 3, 2));
    edges.add(new Edge(2, 3, 3));
    ArrayList<Integer> dist = bellmanFord(V, edges, src);

    System.out.println("Shortest distances from source:");
    for (int d : dist) System.out.print(d + " ");

    System.out.println("\n============= Negative wt cycle ===================");
    ArrayList<Edge> edges1 = new ArrayList<>();
    edges1.add(new Edge(0, 1, 1));
    edges1.add(new Edge(1, 2, -1));
    edges1.add(new Edge(2, 0, -1));
    bellmanFord(V, edges1, src);
  }

  private static ArrayList<Integer> bellmanFord(int V, ArrayList<Edge> edges, int src) {
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    // Step 1: Relax all edges V-1 times
    for (int i = 1; i <= V - 1; i++) {
      for (Edge e : edges) {
        if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.wt < dist[e.v]) {
          dist[e.v] = dist[e.u] + e.wt;
        }
      }
    }

    // Step 2: Check for negative weight cycle
    for (Edge e : edges) {
      if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.wt < dist[e.v]) {
        System.out.println("Negative weight cycle detected");
        return new ArrayList<>();
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int d : dist) result.add(d);

    return result;
  }
}
