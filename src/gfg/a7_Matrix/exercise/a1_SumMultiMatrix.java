package gfg.a7_Matrix.exercise;

public class a1_SumMultiMatrix {
  public static void main(String[] args) {
    int[][] arr1 = {{1, 2}, {4, 5}};
    int[][] arr2 = {{1, 2}, {4, 5}};

    printMatrix(sumMatrix(arr1, arr2));
    System.out.println("=========");
    printMatrix(multiply(arr1, arr2));
  }

  private static void printMatrix(int[][] arr1) {
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        System.out.print(arr1[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static int[][] sumMatrix(int[][] arr1, int[][] arr2) {
    int row = arr1.length;
    int col = arr1[0].length;
    if (row != arr2.length || col != arr2[0].length) {
      return new int[0][0];
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        arr1[i][j] += arr2[i][j];
      }
    }
    return arr1;
  }

  static int[][] multiply(int[][] A, int[][] B) {
    int r1 = A.length;
    int c1 = A[0].length;
    int r2 = B.length;
    int c2 = B[0].length;

    if (c1 != r2) {
      throw new IllegalArgumentException("Matrix multiplication not possible");
    }

    int[][] res = new int[r1][c2];

    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c2; j++) {
        for (int k = 0; k < c1; k++) {
          res[i][j] += A[i][k] * B[k][j];
        }
      }
    }
    return res;
  }
}
