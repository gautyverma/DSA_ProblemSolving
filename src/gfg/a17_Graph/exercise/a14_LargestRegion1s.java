package gfg.a17_Graph.exercise;

public class a14_LargestRegion1s {
  public static void main(String[] args) {
    int[][] grid = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}};
    System.out.println("Max area :: " + findMaxArea(grid));
  }

  public static int findMaxArea(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    boolean[][] visited = new boolean[n][m];
    int maxArea = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        if (grid[i][j] == 1 && !visited[i][j]) {
          int area = dfs(grid, visited, i, j, n, m);
          maxArea = Math.max(maxArea, area);
        }
      }
    }

    return maxArea;
  }

  private static int dfs(int[][] grid, boolean[][] visited, int row, int col, int n, int m) {

    visited[row][col] = true;
    int count = 1;

    int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    for (int k = 0; k < 8; k++) {
      int newRow = row + dr[k];
      int newCol = col + dc[k];

      if (isValid(newRow, newCol, n, m, grid, visited)) {
        count += dfs(grid, visited, newRow, newCol, n, m);
      }
    }

    return count;
  }

  private static boolean isValid(int r, int c, int n, int m, int[][] grid, boolean[][] visited) {
    return r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1 && !visited[r][c];
  }
}
