package gfg.a17_Graph.exercise;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
* Given an integer x and an undirected acyclic graph with v nodes, labeled from 0 to v-1, and e edges, return the level of node labeled as x.

Level is the minimum number of edges you must travel from the node 0 to some target.

If there doesn't exists such a node that is labeled as x, return -1.
* */
public class a8_LevelofNodes {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> graph = util.getUndirectedGraph();
    System.out.println("Level of node 'x' :: " + nodeLevel(graph.size(), graph, 4));
  }

  public static int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {

    if (X >= V) return -1;

    boolean[] visited = new boolean[V];
    Queue<int[]> q = new LinkedList<>();

    q.offer(new int[] {0, 0}); // {node, level}
    visited[0] = true;

    while (!q.isEmpty()) {

      int[] curr = q.poll();
      int node = curr[0];
      int level = curr[1];

      if (node == X) return level;

      for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          q.offer(new int[] {neighbor, level + 1});
        }
      }
    }

    return -1;
  }
}
