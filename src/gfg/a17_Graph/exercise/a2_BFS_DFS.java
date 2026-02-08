package gfg.a17_Graph.exercise;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a2_BFS_DFS {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> graph = util.getUndirectedGraph();
    System.out.println("BFS " + bfs(graph));
    System.out.println("DFS " + dfs(graph));
  }

  private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res = new ArrayList<>();
    int V = adj.size();
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) dfsRec(i, visited, adj, res);
    }
    return res;
  }

  private static void dfsRec(
      int u, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
    visited[u] = true;
    res.add(u);
    for (Integer v : adj.get(u)) {
      if (!visited[v]) dfsRec(v, visited, adj, res);
    }
  }

  private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res = new ArrayList<>();
    int V = adj.size();
    boolean[] visited = new boolean[V];
    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    visited[0] = true;
    res.add(0);

    while (!q.isEmpty()) {
      Integer u = q.poll();
      for (Integer v : adj.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          q.add(v);
          res.add(v);
        }
      }
    }

    return res;
  }
}
