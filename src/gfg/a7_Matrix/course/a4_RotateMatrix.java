package gfg.a7_Matrix.course;

public class a4_RotateMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    System.out.println("Naive sol :: ");
    printRotateMatrixAntiClockBy90(arr);
    System.out.println("===============");
    System.out.println("Efficient sol :: ");
    rotateEff90(arr);
  }

  /*
   * 1. get Transpose of matrix
   * 2. Reverse individual columns (top ↔ bottom)
   */
  private static void rotateEff90(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    int[][] transArr = new int[col][row];

    // 1. Transpose of matrix
    System.out.println("1. Transpose of matrix");
    for (int r = 0; r < col; r++) {
      for (int c = 0; c < row; c++) {
        transArr[r][c] = arr[c][r];
        System.out.print(transArr[r][c] + " ");
      }
      System.out.println();
    }

    // 2. Reverse individual columns
    for (int j = 0; j < row; j++) {
      int first = 0;
      int last = col - 1;

      while (first < last) {
        int temp = transArr[first][j];
        transArr[first][j] = transArr[last][j];
        transArr[last][j] = temp;

        first++;
        last--;
      }
    }

    // Print final rotated matrix
    System.out.println("2. Rotated Matrix (90° Anti-Clockwise)");
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        System.out.print(transArr[i][j] + " ");
      }
      System.out.println();
    }
  }


  private static void printRotateMatrixAntiClockBy90(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    for (int i = col - 1; i >= 0; i--) {
      for (int j = 0; j < row; j++) {
        System.out.print(arr[j][i] + " ");
      }
      System.out.println();
    }

    System.out.println("===============");
    int[][] tArr = new int[col][row];

    // store rotated values
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        tArr[col - j - 1][i] = arr[i][j];
      }
    }

    // print rotated matrix
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        System.out.print(tArr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
