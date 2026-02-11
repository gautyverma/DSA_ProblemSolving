package gfg.a17_Graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class a6_FindNumberOfIslands {
  public static void main(String[] args) {
    int[][] grid = {
      {'L', 'L', 'W', 'W', 'W'},
      {'W', 'L', 'W', 'W', 'L'},
      {'L', 'W', 'W', 'L', 'L'},
      {'W', 'W', 'W', 'W', 'W'},
      {'L', 'W', 'L', 'L', 'W'}
    };

    System.out.println("Number of Islands using BFS :: " + countIslandsBfs(grid));
  }

  private static int countIslandsBfs(int[][] grid) {
    int row = grid.length, col = grid[0].length;
    boolean[][] visited = new boolean[row][col];
    int count = 0;
    // 8 directions
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 'L' && !visited[i][j]) {
          count++;
          bfs(grid, visited, i, j, dx, dy);
        }
      }
    }
    return count;
  }

  private static void bfs(int[][] grid, boolean[][] visited, int x, int y, int[] dx, int[] dy) {
    Queue<int[]> q = new LinkedList<>();
    visited[x][y] = true;
    q.offer(new int[] {x, y});

    while (!q.isEmpty()) {
      int[] cell = q.poll();
      int cx = cell[0], cy = cell[1];
      for (int i = 0; i < 8; i++) {
        int nx = cx + dx[i], ny = cy + dy[i];
        if (nx >= 0
            && ny >= 0
            && nx < grid.length
            && ny < grid[0].length
            && grid[nx][ny] == 'L'
            && !visited[nx][ny]) {
          visited[nx][ny] = true;
          q.offer(new int[] {nx, ny});
        }
      }
    }
  }
}
