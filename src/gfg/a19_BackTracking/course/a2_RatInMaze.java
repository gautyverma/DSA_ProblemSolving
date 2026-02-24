package gfg.a19_BackTracking.course;

public class a2_RatInMaze {
  static int N = 4;

  public static void main(String[] args) {
    int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
    int[][] sol = new int[N][N];
    if (solveMaze(maze, 0, 0, sol)) {
      printSol(sol);
    } else {
      System.out.println("No path found");
    }
  }

  private static void printSol(int[][] sol) {
    for (int i = 0; i < sol.length; i++) {
      for (int j = 0; j < sol[0].length; j++) {
        System.out.print(sol[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static boolean solveMaze(int[][] maze, int row, int col, int[][] sol) {
    // base condition
    if (row == N - 1 && col == N - 1 && maze[row][col] == 1) {
      sol[row][col] = 1;
      return true;
    }

    // sol[row][col] checks for visited place 0 is unvisited
    if (isSafe(maze, row, col) && sol[row][col] == 0) {
      sol[row][col] = 1;

      if (solveMaze(maze, row + 1, col, sol)) return true;
      if (solveMaze(maze, row - 1, col, sol)) return true;
      if (solveMaze(maze, row, col + 1, sol)) return true;
      if (solveMaze(maze, row, col - 1, sol)) return true;

      sol[row][col] = 0;
    }
    return false;
  }

  private static boolean isSafe(int[][] maze, int row, int col) {
    return (row >= 0 && row < N && col >= 0 && col < N && maze[row][col] == 1);
  }
}
