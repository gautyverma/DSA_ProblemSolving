package gfg.a17_Graph.course;

import gfg.a17_Graph.common.Edge;
import gfg.a17_Graph.common.OPS_Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*It finds Strongly Connected Components (SCCs) in a directed graph.*/
public class a13_Kosaraju_StronglyConnected {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = util.getDirectedSSCGraph();
    util.printGraph(adj);
    System.out.println("=============");
    System.out.println("SSC[Strongly Connected Components] :" + kosaraju(adj));
  }

  /*
  Algorithm: Kosaraju’s Algorithm for Strongly Connected Components

  Input the directed graph.
  Create a visited array and an empty stack.
  Perform DFS for each unvisited vertex.
  After finishing DFS of a vertex, push it into the stack.
  Reverse (transpose) all edges of the graph.
  Reset the visited array.
  While the stack is not empty:
    a. Pop a vertex from the stack.
    b. If the vertex is not visited:
    i. Perform DFS on the transposed graph.
    ii. All vertices visited in this DFS form one strongly connected component.
  Repeat until the stack becomes empty.
  Output all strongly connected components.
  */

  private static ArrayList<ArrayList<Integer>> kosaraju(ArrayList<ArrayList<Integer>> adj) {
    int V = adj.size();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    // Step 1: DFS to fill stack by finish time
    boolean[] visited = new boolean[V];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        DFS1(i, adj, visited, st);
      }
    }
    // Step 2: Transpose graph
    ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      transpose.add(new ArrayList<>());
    }
    for (int u = 0; u < V; u++) {
      for (int v : adj.get(u)) {
        transpose.get(v).add(u);
      }
    }
    // Step 3: DFS on transposed graph using stack order
    Arrays.fill(visited, false);
    while (!st.isEmpty()) {
      int u = st.pop();
      if (!visited[u]) {
        ArrayList<Integer> component = new ArrayList<>();
        dfs2(u, transpose, visited, component);
        res.add(component);
      }
    }
    return res;
  }

  // DFS 2: collect one SCC
  private static void dfs2(
      int u,
      ArrayList<ArrayList<Integer>> transpose,
      boolean[] visited,
      ArrayList<Integer> component) {

    visited[u] = true;
    component.add(u);
    for (int v : transpose.get(u)) {
      if (!visited[v]) {
        dfs2(v, transpose, visited, component);
      }
    }
  }

  // DFS 1: store vertices by finish time
  private static void DFS1(
      int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
    visited[u] = true;
    for (int i = 0; i < adj.get(u).size(); i++) {
      if (!visited[i]) {
        DFS1(i, adj, visited, st);
      }
    }
    st.push(u);
  }
}
