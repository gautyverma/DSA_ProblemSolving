package gfg.a17_Graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/*
*
Given  a grid of n*m consisting of O's and X's. The task is to find the number of 'X' total shapes.
Note: 'X' shape consists of one or more adjacent X's (diagonals not included).


Example 1:

Input: grid = {{X,O,X},{O,X,O},{X,X,X}}
Output: 3
Explanation:
The grid is-
X O X
O X O
X X X
So, X with same colour are adjacent to each
other vertically for horizontally (diagonals
not included). So, there are 3 different groups
in the given grid.
*
* */
public class a10_xTotalShapes {
  public static void main(String[] args) {
    char[][] grid = {{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'X', 'X', 'X'}};
    System.out.println("Number of x :: " + countXShapesDFS(grid));
    System.out.println("------------------");
    System.out.println("Number of x :: " + countXShapesBFS(grid));
  }

  private static int countXShapesBFS(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[row][col];
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 'X' && !visited[i][j]) {
          bfs(grid, visited, i, j, row, col);
          count++;
        }
      }
    }

    return count;
  }

  private static void bfs(char[][] grid, boolean[][] visited, int i, int j, int row, int col) {
    Queue<int[]> q = new LinkedList<>();
    visited[i][j] = true;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    q.offer(new int[] {i, j});
    while (!q.isEmpty()) {
      int[] cell = q.poll();
      int x = cell[0], y = cell[1];
      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d], ny = y + dy[d];
        if (nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny] && grid[nx][ny] == 'X') {
          visited[nx][ny] = true;
          q.offer(new int[] {nx, ny});
        }
      }
    }
  }

  private static int countXShapesDFS(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[row][col];
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 'X' && !visited[i][j]) {
          dfs(grid, visited, i, j, row, col);
          count++;
        }
      }
    }

    return count;
  }

  private static void dfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {

    // Boundary + condition check
    if (i < 0 || j < 0 || i >= n || j >= m) return;

    if (grid[i][j] != 'X' || visited[i][j]) return;

    visited[i][j] = true;

    // 4 directions only (no diagonals)
    dfs(grid, visited, i - 1, j, n, m); // up
    dfs(grid, visited, i + 1, j, n, m); // down
    dfs(grid, visited, i, j - 1, n, m); // left
    dfs(grid, visited, i, j + 1, n, m); // right
  }
}
