package gfg.a7_Matrix.exercise;

public class a6_BeautifulMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 2, 3}, {3, 2, 1}};
    System.out.println(
        "Min operations to make matrix beautiful :: " + findMinOperation(arr, arr.length));
  }

  private static int findMinOperation(int[][] mat, int n) {
    int[] rowSum = new int[n];
    int[] colSum = new int[n];

    // Step 1: Calculate row sums and column sums
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        rowSum[i] += mat[i][j];
        colSum[j] += mat[i][j];
      }
    }

    // Step 2: Find maximum sum
    int target = 0;
    for (int i = 0; i < n; i++) {
      target = Math.max(target, rowSum[i]);
      target = Math.max(target, colSum[i]);
    }

    // Step 3: Count total operations (row deficits)
    int operations = 0;
    for (int i = 0; i < n; i++) {
      operations += (target - rowSum[i]);
    }

    return operations;
  }
}
