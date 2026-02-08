package gfg.a7_Matrix.exercise;

public class a5_BooleanMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {0, 0, 0}};
    booleanMat(arr);
    printMatirx(arr);
  }

  private static void printMatirx(int[][] arr) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void booleanMat(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    boolean[] isRow1 = new boolean[row];
    boolean[] isCol1 = new boolean[col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] == 1) {
          isRow1[i] = true;
          isCol1[j] = true;
        }
      }
    }

    for (int i = 0; i < row; i++) {
      if (isRow1[i] == true) {
        for (int j = 0; j < col; j++) {
          arr[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < col; i++) {
      if (isCol1[i] == true) {
        for (int j = 0; j < row; j++) {
          arr[j][i] = 1;
        }
      }
    }
  }
}
