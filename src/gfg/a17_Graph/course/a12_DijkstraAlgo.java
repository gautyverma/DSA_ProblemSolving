package gfg.a17_Graph.course;

/*
* Edges shown:
0 — 1 (5)
0 — 2 (10)
1 — 2 (3)
1 — 3 (20)
2 — 3 (2)
* */

import java.util.ArrayList;
import java.util.Arrays;

public class a12_DijkstraAlgo {
  public static void main(String[] args) {
    int[][] graph = new int[][] {{0, 5, 10, 0}, {5, 0, 3, 20}, {10, 3, 0, 2}, {0, 20, 2, 0}};
    System.out.println("1. Naive solution : " + naiveDijkstra(graph, 0));
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
}
