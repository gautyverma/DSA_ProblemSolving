package gfg.a19_BackTracking.exercise;

import java.util.ArrayList;
import java.util.List;

/*
* You are given an undirected graph consisting of V vertices and
* E edges represented by a list edges[][], along with an integer m.
* Your task is to determine whether it is possible to color the
* graph using at most m different colors such that no two adjacent vertices share the same color.
*  Return true if the graph can be colored with at most m colors, otherwise return false.

Note: The graph is indexed with 0-based indexing.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors,
*  for example, one of the possible ways vertices can be colored as follows:

Vertex 0: Color 1
Vertex 1: Color 2
Vertex 2: Color 2
Vertex 3: Color 3
* */
public class a2_MColoring {
  public static void main(String[] args) {
    int V = 3, m = 2;
    int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
    System.out.println("Is possible :: " + graphColoring(V, edges, m));
  }

  private static boolean graphColoring(int V, int[][] edges, int m) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    int[] color = new int[V];
    return solve(0, V, adj, color, m);
  }

  private static boolean solve(int vertex, int V, List<List<Integer>> adj, int[] color, int m) {
    if (vertex == V) return true;
    for (int c = 1; c <= m; c++) {
      if (isSafe(vertex, adj, color, c)) {
        color[vertex] = c;
        if (solve(vertex + 1, V, adj, color, m)) {
          return true;
        }
        color[vertex] = 0;
      }
    }
    return false;
  }

  private static boolean isSafe(int vertex, List<List<Integer>> adj, int[] color, int c) {
    for (int neighbor : adj.get(vertex)) {
      if (color[neighbor] == c) return false;
    }
    return true;
  }
}
