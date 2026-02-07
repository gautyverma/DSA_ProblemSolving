package gfg.a7_Matrix.course;

public class a3_TransposeMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
    printTransposeMatrix(arr);
  }

  private static void printTransposeMatrix(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    int[][] transArr = new int[col][row];

    for (int r = 0; r < col; r++) {
      for (int c = 0; c < row; c++) {
        transArr[r][c] = arr[c][r];
        System.out.print(arr[c][r] + " ");
      }
      System.out.println();
    }
  }
}
