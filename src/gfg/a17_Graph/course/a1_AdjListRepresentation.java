package gfg.a17_Graph.course;

import java.util.ArrayList;

public class a1_AdjListRepresentation {
  public static void main(String[] args) {
    int vertices = 5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
    for (int i = 0; i < vertices; i++) {
      adj.add(new ArrayList<Integer>());
    }
    addEdgeUndirected(adj, 0, 1);
    addEdgeUndirected(adj, 0, 2);
    addEdgeUndirected(adj, 1, 2);
    addEdgeUndirected(adj, 1, 3);

    printGraph(adj);
  }

  private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
    for (int i = 0; i < adj.size(); i++) {
      System.out.print(i + " -> ");
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(adj.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  private static void addEdgeUndirected(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }
}
