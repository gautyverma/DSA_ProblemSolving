package gfg.a17_Graph.course;

import gfg.a17_Graph.common.OPS_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Kahn's Algorithm
 * */
public class a7_TopologicalSortBFS {
  public static void main(String[] args) {
    OPS_Graph util = new OPS_Graph();
    ArrayList<ArrayList<Integer>> acyclicGraph = util.getDirectedAcyclicGraph();
    util.printGraph(acyclicGraph);
    System.out.println("------------");
    System.out.println(
        "Topological sort BFS using kahn's algorithm : " + topoSortBFS(acyclicGraph));
    System.out.println("------------");
  }

  private static ArrayList<Integer> topoSortBFS(ArrayList<ArrayList<Integer>> acyclicGraph) {
    int V = acyclicGraph.size();

    // compute indegree
    int[] indegree = new int[V];
    for (int i = 0; i < V; i++) {
      for (int num : acyclicGraph.get(i)) {
        indegree[num]++;
      }
    }
    Queue<Integer> q = new LinkedList<>();
    // Enqueue vertices with 0 indegree
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) q.add(i);
    }
    ArrayList<Integer> result = new ArrayList<>();
    // kahn's algorithm
    while (!q.isEmpty()) {
      int u = q.poll();
      result.add(u);
      for (int v : acyclicGraph.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) q.add(v);
      }
    }
    return result;
  }
}
