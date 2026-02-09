package gfg.a17_Graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class a3_DistanceOfNearestCellHaving1 {
  public static void main(String[] args) {
    int[][] grid = {{0, 0, 1}, {0, 0, 0}, {1, 0, 0}};
    printMatix(grid);
    System.out.println("==========");
    printMatix(nearest(grid));
  }

  private static void printMatix(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static int[][] nearest(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int[][] dist = new int[row][col];
    Queue<int[]> q = new LinkedList<>();

    // Step - 1 initialize queue and distance matrix
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          dist[i][j] = 0;
          q.offer(new int[] {i, j});
        } else {
          dist[i][j] = -1;
        }
      }
    }
    // Directions up,down,left,right
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // Step 2 - BFS
    while (!q.isEmpty()) {
      int[] cell = q.poll();
      int x = cell[0];
      int y = cell[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx >= 0 && ny >= 0 && nx < row && ny < col && dist[nx][ny] == -1) {
          dist[nx][ny] = dist[x][y] + 1;
          q.offer(new int[] {nx, ny});
        }
      }
    }

    return dist;
  }
}
