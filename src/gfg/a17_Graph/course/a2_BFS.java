package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a2_BFS {
  public static void main(String[] args) {
    OPS_Graph graph = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = graph.getUndirectedGraph();
    graph.printGraph(adj);
    System.out.println("------------");
    System.out.println("BFS_1 -> " + bfs1(adj, 0));
    System.out.println("------------");

    ArrayList<ArrayList<Integer>> adj2 = graph.getMultiUndirectedGraph();
    graph.printGraph(adj2);
    System.out.println("------------");
    System.out.println("BFS_2 -> " + bfs2(adj2));
    System.out.println("------------");
  }

  /* Version 2 - Given multiple undirected graph, print BFS from given source.
   * */
  private static ArrayList<Integer> bfs2(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res = new ArrayList<>();

    int vertices = adj.size();
    boolean[] visited = new boolean[vertices];
    for (int i = 0; i < vertices; i++) {
      if (!visited[i]) {
        bfsConnected(adj, i, visited, res);
      }
    }
    return res;
  }

  private static void bfsConnected(
      ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, ArrayList<Integer> res) {
    Queue<Integer> q = new LinkedList<>();
    visited[src] = true;
    q.add(src);
    while (!q.isEmpty()) {
      int u = q.poll();
      //      System.out.print(u + " ");
      res.add(u);
      for (int v : adj.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          q.add(v);
        }
      }
    }
  }

  /* Version 1 - Given an undirected graph and a source vertex's, print BFS from given source.
   * */
  private static ArrayList<Integer> bfs1(ArrayList<ArrayList<Integer>> adj, int source) {
    int vertices = adj.size();
    boolean[] visited = new boolean[vertices];
    ArrayList<Integer> res = new ArrayList<>();

    Queue<Integer> q = new LinkedList<>();
    visited[source] = true;
    q.add(source);
    while (!q.isEmpty()) {
      int u = q.poll();
      //      System.out.print(u + " ");
      res.add(u);
      for (int v : adj.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          q.add(v);
        }
      }
    }
    return res;
  }
}
