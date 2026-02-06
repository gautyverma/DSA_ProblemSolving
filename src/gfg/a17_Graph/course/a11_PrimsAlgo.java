package gfg.a17_Graph.course;

/*
* Edges shown:
0 — 1 (5)
0 — 2 (8)
1 — 2 (10)
1 — 3 (15)
2 — 3 (20)
* */

import gfg.a17_Graph.common.Edge;
import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class a11_PrimsAlgo {
  public static void main(String[] args) {
    int[][] graph = new int[][] {{0, 5, 8, 0}, {5, 0, 10, 15}, {8, 10, 0, 20}, {0, 15, 20, 0}};
    primsAlgo(graph);
    System.out.println("===============");
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Edge>> adj = util.getWeightedUnDirectedGraph();
    primsAlgo(adj);
  }

  private static void primsAlgo(int[][] graph) {
    int V = graph.length;
    int[] key = new int[V];

    Boolean[] mstSet = new Boolean[V];
    // Initialize all keys as INFINITE
    for (int i = 0; i < V; i++) {
      key[i] = Integer.MAX_VALUE;
      mstSet[i] = false;
    }

    int res = 0;
    // Always include first 1st vertex in MST.
    // Make key 0 so that this vertex is
    // picked as first vertex
    key[0] = 0;

    // Array to store constructed MST
    int parent[] = new int[V];

    // First node is always root of MST
    parent[0] = -1;

    // The MST will have V vertices
    for (int count = 0; count < V - 1; count++) {

      // Pick the minimum key vertex from the set of
      // vertices not yet included in MST
      int u = minKey(key, mstSet);

      // Add the picked vertex to the MST Set
      mstSet[u] = true;

      // Update key value and parent index of the
      // adjacent vertices of the picked vertex.
      // Consider only those vertices which are not
      // yet included in MST
      for (int v = 0; v < V; v++)

        // graph[u][v] is non zero only for adjacent
        // vertices of m mstSet[v] is false for
        // vertices not yet included in MST Update
        // the key only if graph[u][v] is smaller
        // than key[v]
        if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
          parent[v] = u;
          key[v] = graph[u][v];
        }
    }

    // Print the constructed MST
    printMST(parent, graph);
  }

  // A utility function to find the vertex with minimum
  // key value, from the set of vertices not yet included
  // in MST
  static int minKey(int key[], Boolean mstSet[]) {
    // Initialize min value
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int v = 0; v < mstSet.length; v++)
      if (mstSet[v] == false && key[v] < min) {
        min = key[v];
        min_index = v;
      }

    return min_index;
  }

  // A utility function to print the constructed MST
  // stored in parent[]
  static void printMST(int parent[], int graph[][]) {
    System.out.println("Edge \tWeight");
    for (int i = 1; i < graph.length; i++)
      System.out.println(parent[i] + " - " + i + "\t" + graph[parent[i]][i]);
  }

  // ********************

  private static void primsAlgo(ArrayList<ArrayList<Edge>> adj) {

    int V = adj.size();

    int[] key = new int[V];
    int[] parent = new int[V];
    boolean[] inMST = new boolean[V];

    Arrays.fill(key, Integer.MAX_VALUE);
    Arrays.fill(parent, -1);

    // Min heap {key, vertex}
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    // Start from vertex 0
    key[0] = 0;
    pq.add(new int[] {0, 0});

    while (!pq.isEmpty()) {

      int[] curr = pq.poll();
      int u = curr[1];

      if (inMST[u]) continue;

      inMST[u] = true;

      // Explore neighbors
      for (Edge edge : adj.get(u)) {

        int v = edge.v;
        int weight = edge.weight;

        if (!inMST[v] && weight < key[v]) {
          key[v] = weight;
          parent[v] = u;
          pq.add(new int[] {key[v], v});
        }
      }
    }

    printMST(parent, key);
  }

  private static void printMST(int[] parent, int[] key) {
    System.out.println("Edge\tWeight");
    for (int i = 1; i < parent.length; i++) {
      System.out.println(parent[i] + " - " + i + "\t" + key[i]);
    }
  }
}
