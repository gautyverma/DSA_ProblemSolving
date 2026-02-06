package gfg.a17_Graph.exercise;

import java.util.ArrayList;
import java.util.List;

/*
*
*
Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.

Example 1:

Input:
V = 5, E = 7
edges = [[0,1], [0,4], [4,1], [4,3], [1,3], [1,2], [3,2]]

Output:
[[1,4], [0,2,3,4], [1,3], [1,2,4], [0,1,3]]
Explanation:
Node 0 is connected to 1 and 4.
Node 1 is connected to 0,2,3 and 4.
Node 2 is connected to 1 and 3.
Node 3 is connected to 1,2 and 4.
Node 4 is connected to 0,1 and 3.
* */
public class a1_EdgeToList {
  public static void main(String[] args) {
    int[][] edges = {{0, 1}, {0, 4}, {4, 1}, {4, 3}, {1, 3}, {1, 2}, {3, 2}};
    int v = 5;
    System.out.println(printGraph(v, edges));
  }

  private static List<List<Integer>> printGraph(int V, int[][] edges) {
    int n = edges.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      res.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      addEdge(res, edges[i][0], edges[i][1]);
    }
    return res;
  }

  private static void addEdge(List<List<Integer>> res, int u, int v) {
    res.get(u).add(v);
    res.get(v).add(u);
  }
}
