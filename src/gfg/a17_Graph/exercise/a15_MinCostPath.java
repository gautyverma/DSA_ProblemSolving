package gfg.a17_Graph.exercise;

import java.util.Arrays;
import java.util.PriorityQueue;

public class a15_MinCostPath {
  public static void main(String[] args) {
    int[][] grid = {{9, 4, 9, 9}, {6, 7, 6, 4}, {8, 3, 3, 7}, {7, 4, 9, 10}};

    System.out.println("Min cost from (0, 0) to (n-1, n-1) :: " + minCostPath(grid));
  }

  private static int minCostPath(int[][] grid) {
    int n = grid.length;
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.add(new int[] {grid[0][0], 0, 0}); // totalCost,row,col
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int cost = curr[0], r = curr[1], c = curr[2];
      if (r == n - 1 && c == n - 1) return cost;
      for (int k = 0; k < 4; k++) {
        int nr = r + dr[k], nc = c + dc[k];
        if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
          int newCost = cost + grid[nr][nc];
          if (newCost < dist[nr][nc]) {
            dist[nr][nc] = newCost;
            pq.offer(new int[] {newCost, nr, nc});
          }
        }
      }
    }
    return dist[n - 1][n - 1];
  }
}
