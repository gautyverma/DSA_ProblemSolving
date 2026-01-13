package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Kahn's Algorithm
 * */
public class a8_DetectCycleInDirectGraphKahnsAlgo {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> acyclicGraph = util.getDirectedAcyclicGraph();
    util.printGraph(acyclicGraph);
    System.out.println("------------");
    System.out.println(
        "Is there a cycle in graph using kahn's algorithm : "
            + detectCycleInDirectedGraph(acyclicGraph));
    System.out.println("------------");
    ArrayList<ArrayList<Integer>> directedGraph = util.getDirectedCyclicGraph();
    util.printGraph(directedGraph);
    System.out.println("------------");
    System.out.println(
        "Is there a cycle in graph using kahn's algorithm : "
            + detectCycleInDirectedGraph(directedGraph));
    System.out.println("------------");
  }

  private static boolean detectCycleInDirectedGraph(ArrayList<ArrayList<Integer>> adj) {
    int V = adj.size();

    // compute indegree
    int[] indegree = new int[V];
    for (int i = 0; i < V; i++) {
      for (int num : adj.get(i)) {
        indegree[num]++;
      }
    }
    Queue<Integer> q = new LinkedList<>();
    // Enqueue vertices with 0 indegree
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) q.add(i);
    }
    int count = 0;
    // kahn's algorithm
    while (!q.isEmpty()) {
      int u = q.poll();
      for (int v : adj.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) q.add(v);
      }
      count++;
    }
    return V != count;
  }
}
