package gfg.a17_Graph.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*MST - result*/
public class a18_KruskalAlgo {
  // Edge representation
  static class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
      src = s;
      dest = d;
      weight = w;
    }

    // Sort edges by weight
    public int compareTo(Edge other) {
      return this.weight - other.weight;
    }
  }

  // Disjoint Set Union (Union-Find)
  static class DSU {
    int[] parent, rank;

    DSU(int n) {
      parent = new int[n];
      rank = new int[n];

      for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 0;
      }
    }

    // Find with path compression
    int find(int x) {
      if (parent[x] != x) {
        parent[x] = find(parent[x]);
      }
      return parent[x];
    }

    // Union by rank
    void union(int x, int y) {
      int px = find(x);
      int py = find(y);

      if (px == py) return;

      if (rank[px] < rank[py]) {
        parent[px] = py;
      } else if (rank[px] > rank[py]) {
        parent[py] = px;
      } else {
        parent[py] = px;
        rank[px]++;
      }
    }
  }

  // Kruskal's Algorithm
  static void kruskal(int V, List<Edge> edges) {

    // Sort edges by weight
    Collections.sort(edges);

    DSU dsu = new DSU(V);
    int mstWeight = 0;

    System.out.println("Edges in Minimum Spanning Tree:");

    for (Edge e : edges) {

      int u = e.src;
      int v = e.dest;

      // If adding this edge doesn't form a cycle
      if (dsu.find(u) != dsu.find(v)) {
        dsu.union(u, v);
        mstWeight += e.weight;
        System.out.println(u + " -- " + v + " == " + e.weight);
      }
    }

    System.out.println("Total MST weight = " + mstWeight);
  }

  // Driver
  public static void main(String[] args) {

    int V = 5;
    List<Edge> edges = new ArrayList<>();

    edges.add(new Edge(0, 1, 10));
    edges.add(new Edge(0, 2, 8));

    edges.add(new Edge(1, 2, 5));
    edges.add(new Edge(1, 3, 3));

    edges.add(new Edge(2, 3, 4));
    edges.add(new Edge(2, 4, 12));

    edges.add(new Edge(3, 4, 15));
    kruskal(V, edges);
  }
}
