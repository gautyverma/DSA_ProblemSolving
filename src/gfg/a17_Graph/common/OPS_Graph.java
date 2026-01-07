package gfg.a17_Graph.common;

import java.util.ArrayList;

public class OPS_Graph {

  /*

     Graph Diagram:

            0
           / \
          1---2
          | \ |
          |  \|
          3---4

    Adjacency List Representation:

    0 -> 1, 2
    1 -> 0, 2, 3
    2 -> 0, 1, 3, 4
    3 -> 1, 2, 4
    4 -> 2, 3
  */

  public ArrayList<ArrayList<Integer>> getUndirectedGraph() {
    int vertices = 5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
    for (int i = 0; i < vertices; i++) {
      adj.add(new ArrayList<Integer>());
    }
    addEdgeUndirected(adj, 0, 1);
    addEdgeUndirected(adj, 0, 2);
    addEdgeUndirected(adj, 1, 2);
    addEdgeUndirected(adj, 1, 3);
    addEdgeUndirected(adj, 2, 3);
    addEdgeUndirected(adj, 2, 4);
    addEdgeUndirected(adj, 3, 4);
    return adj;
  }

  /*
  * Adjacency List
  --------------
  0 -> 1 2
  1 -> 0 2 3
  2 -> 0 1 3
  3 -> 1 2

  4 -> 5 6
  5 -> 4 6
  6 -> 4 5
  *
  * Component 1:

        0
       / \
      1---2
       \ /
        3

  Component 2:

        4
       / \
      5---6
  * */
  public ArrayList<ArrayList<Integer>> getMultiUndirectedGraph() {
    int vertices = 7;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
    for (int i = 0; i < vertices; i++) {
      adj.add(new ArrayList<Integer>());
    }
    addEdgeUndirected(adj, 0, 1);
    addEdgeUndirected(adj, 0, 2);
    addEdgeUndirected(adj, 1, 2);
    addEdgeUndirected(adj, 1, 3);
    addEdgeUndirected(adj, 2, 3);

    addEdgeUndirected(adj, 4, 5);
    addEdgeUndirected(adj, 4, 6);
    addEdgeUndirected(adj, 5, 6);

    return adj;
  }

  public ArrayList<ArrayList<Integer>> getUndirectedGraphShortest() {
    int vertices = 4;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
    for (int i = 0; i < vertices; i++) {
      adj.add(new ArrayList<Integer>());
    }
    addEdgeUndirected(adj, 0, 1);
    addEdgeUndirected(adj, 0, 2);
    addEdgeUndirected(adj, 1, 2);
    addEdgeUndirected(adj, 1, 3);
    addEdgeUndirected(adj, 2, 3);
    return adj;
  }

  public void printGraph(ArrayList<ArrayList<Integer>> adj) {
    for (int i = 0; i < adj.size(); i++) {
      System.out.print(i + " -> ");
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(adj.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  private void addEdgeUndirected(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  /*
  *
  *
  * 0 ───▶ 1 ◀─── 2 ───▶  3 ───▶ 4 ───▶ 5
                          ▲               │
                          └───────────────┘
  0 → 1
  1 →
  2 → 1, 3
  3 → 4
  4 → 5
  5 → 3
  * */
  public ArrayList<ArrayList<Integer>> getDirectedGraphCyclic() {
    int vertices = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
    for (int i = 0; i < vertices; i++) {
      adj.add(new ArrayList<Integer>());
    }
    addEdgeDirected(adj, 0, 1);

    addEdgeDirected(adj, 2, 1);
    addEdgeDirected(adj, 2, 3);

    addEdgeDirected(adj, 3, 4);
    addEdgeDirected(adj, 4, 5);
    addEdgeDirected(adj, 5, 3);

    return adj;
  }

  private void addEdgeDirected(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
  }
}
