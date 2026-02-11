package gfg.a17_Graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall (blocked cell which we cannot traverse).
Note: There are only a single source and a single destination.
* */
public class a7_FindExists {
  public static void main(String[] args) {
    int[][] grid = {{1, 3, 0, 0}, {3, 3, 3, 0}, {0, 0, 3, 3}, {0, 0, 0, 2}};
    System.out.println("Is path exits using dfs :: " + isPathExitsDFS(grid));
    System.out.println("---------------------------------");
    System.out.println("Is path exits using bfs :: " + isPathExitsBFS(grid));
  }

  private static boolean isPathExitsBFS(int[][] grid) {
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    int sx = -1, sy = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          sx = i;
          sy = j;
        }
      }
    }
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {sx, sy});
    visited[sx][sy] = true;

    // directions
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    while (!q.isEmpty()) {
      int[] cell = q.poll();
      int x = cell[0], y = cell[1];
      // If destination found
      if (grid[x][y] == 2) return true;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && grid[nx][ny] != 0) {
          if (grid[nx][ny] == 2) return true;
          q.offer(new int[] {nx, ny});
        }
      }
    }

    return false;
  }

  private static boolean isPathExitsDFS(int[][] grid) {
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    int sx = -1, sy = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          sx = i;
          sy = j;
        }
      }
    }
    return dfsIfPathExists(grid, visited, sx, sy, n);
  }

  private static boolean dfsIfPathExists(int[][] grid, boolean[][] visited, int x, int y, int n) {

    // Out of bounds
    if (x < 0 || y < 0 || x >= n || y >= n) return false;

    // Wall or already visited
    if (grid[x][y] == 0 || visited[x][y]) return false;

    // Destination found
    if (grid[x][y] == 2) return true;

    visited[x][y] = true;

    // Explore 4 directions
    return dfsIfPathExists(grid, visited, x - 1, y, n)
        || // up
        dfsIfPathExists(grid, visited, x + 1, y, n)
        || // down
        dfsIfPathExists(grid, visited, x, y - 1, n)
        || // left
        dfsIfPathExists(grid, visited, x, y + 1, n); // right
  }
}
