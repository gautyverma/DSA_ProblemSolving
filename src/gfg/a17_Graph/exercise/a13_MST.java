package gfg.a17_Graph.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given a weighted, undirected, and connected graph with V vertices and E edges,
 * your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph.
 * The graph is provided as a list of edges, where each edge is represented as [u, v, w],
 * indicating an edge between vertex u and vertex v with edge weight w.
 * */
public class a13_MST {
  public static void main(String[] args) {
    int[][] edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
    System.out.println("MST using prim's :: " + prims(3, edges));
  }

  private static int prims(int V, int[][] edges) {
    List<List<int[]>> adj = new ArrayList<>();
    int res = 0;
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int u = edge[0], v = edge[1], w = edge[2];
      adj.get(u).add(new int[] {v, w});
      adj.get(v).add(new int[] {u, w});
    }
    boolean[] visited = new boolean[V];
    // pr according to weight
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[] {0, 0}); // weight,node

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int w = curr[0], u = curr[1];
      if(visited[u])continue;
      visited[u] = true;
      res += w;
      for(int[] v:adj.get(u)){
        int nextNode = v[0] , nextWeight = v[1];
        if(!visited[nextNode]){
          pq.offer(new int[]{nextWeight,nextNode});
        }
      }
    }
    return res;
  }
}
