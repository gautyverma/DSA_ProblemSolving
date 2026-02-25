package gfg.a19_BackTracking.course;

public class a4_SudokuProblem {
  static final int M = 4;
  static final int N = 9;

  public static void main(String[] args) {
    int[][] grid99 = {
      {5, 3, 0, 0, 7, 0, 0, 0, 0},
      {6, 0, 0, 1, 9, 5, 0, 0, 0},
      {0, 9, 8, 0, 0, 0, 0, 6, 0},
      {8, 0, 0, 0, 6, 0, 0, 0, 3},
      {4, 0, 0, 8, 0, 3, 0, 0, 1},
      {7, 0, 0, 0, 2, 0, 0, 0, 6},
      {0, 6, 0, 0, 0, 0, 2, 8, 0},
      {0, 0, 0, 4, 1, 9, 0, 0, 5},
      {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };
    if (solve(grid99, N)) printBoard(grid99);
    else System.out.println("No solution exists");
    System.out.println("===============");
    int[][] grid44 = {{1, 0, 3, 0}, {0, 0, 2, 1}, {0, 1, 0, 2}, {2, 4, 0, 0}};
    if (solve(grid44, M)) printBoard(grid44);
    else System.out.println("No solution exists");
  }

  private static boolean solve(int[][] grid, int size) {
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (grid[row][col] == 0) {
          for (int num = 1; num <= size; num++) {
            if (isSafe(grid, row, col, num, size)) {
              grid[row][col] = num;
              if (solve(grid, size)) return true;
              grid[row][col] = 0; // Backtrack
            }
          }
          return false; // No number fits
        }
      }
    }
    return true; // No empty cell
  }

  private static boolean isSafe(int[][] grid, int row, int col, int num, int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (grid[i][col] == num || grid[row][j] == num) return false;
      }
    }
    int s = (int) Math.sqrt(size);
    int rs = row - row % s;
    int cs = col - col % s;
    for (int i = 0; i < s; i++) {
      for (int j = 0; j < s; j++) {
        if (grid[i + rs][j + cs] == num) return false;
      }
    }
    return true;
  }

  private static void printBoard(int[][] grid44) {
    for (int[] row : grid44) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}
