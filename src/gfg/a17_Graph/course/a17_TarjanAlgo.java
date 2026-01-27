package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class a17_TarjanAlgo {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> adj = util.getDirectedSSCGraph();
    System.out.println("SSC using tarjan's algo: " + tarjanSSC(adj));
  }

  private static ArrayList<ArrayList<Integer>> tarjanSSC(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    int n = adj.size();
    int[] disc = new int[n];
    int[] low = new int[n];
    Arrays.fill(disc, -1);
    boolean[] inStack = new boolean[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (disc[i] == -1) {
        dfs(i, adj, disc, low, inStack, stack, res);
      }
    }
    return res;
  }

  static int time = 0;

  private static void dfs(
      int u,
      ArrayList<ArrayList<Integer>> adj,
      int[] disc,
      int[] low,
      boolean[] inStack,
      Stack<Integer> stack,
      ArrayList<ArrayList<Integer>> res) {
    disc[u] = low[u] = ++time;
    stack.push(u);
    inStack[u] = true;

    for (int v : adj.get(u)) {
      // tree edge
      if (disc[v] == -1) {
        dfs(v, adj, disc, low, inStack, stack, res);
        low[u] = Math.min(low[u], low[v]);
      } else if (inStack[v]) { // back edge
        low[u] = Math.min(low[u], disc[v]);
      }
    }

    if (low[u] == disc[u]) {
      ArrayList<Integer> scc = new ArrayList<>();
      while (true) {
        int node = stack.pop();
        inStack[node] = false;
        scc.add(node);
        if (node == u) break;
      }
      res.add(scc);
    }
  }
}
