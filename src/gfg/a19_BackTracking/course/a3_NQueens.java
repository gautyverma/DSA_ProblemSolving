package gfg.a19_BackTracking.course;

public class a3_NQueens {
  static int N = 5;

  public static void main(String[] args) {
    int[][] board = new int[N][N];
    if (solve(board, 0)) {
      printBoard(board);
    } else {
      System.out.println("Mo solution exists !");
    }
  }

  private static boolean solve(int[][] board, int row) {
    // base case
    if (row == N) {
      return true;
    }
    for (int col = 0; col < N; col++) {
      if (isSafe(board, row, col)) {
        board[row][col] = 1;

        if (solve(board, row + 1)) {
          return true;
        }
        board[row][col] = 0;
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int row, int col) {
    // Check same column
    for (int i = 0; i < row; i++) if (board[i][col] == 1) return false;

    // Check left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
      if (board[i][j] == 1) return false;

    // Check right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
      if (board[i][j] == 1) return false;

    return true;
  }

  private static void printBoard(int[][] board) {
    for (int[] row : board) {
      for (int cell : row) System.out.print(cell + " ");
      System.out.println();
    }
  }
}
