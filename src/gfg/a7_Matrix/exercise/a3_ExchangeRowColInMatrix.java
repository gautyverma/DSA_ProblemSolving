package gfg.a7_Matrix.exercise;

public class a3_ExchangeRowColInMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    printMatrix(arr);
    System.out.println("After swapping 1st and last col :: ");
    swapCol(arr);
    printMatrix(arr);
    System.out.println("After swapping 1st and last row :: ");
    swapRow(arr);
    printMatrix(arr);
  }

  private static void swapRow(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;
    int top = 0, bottom = row - 1;
    while (top <= bottom) {
      for (int i = 0; i < col; i++) {
        int temp = arr[top][i];
        arr[top][i] = arr[bottom][i];
        arr[bottom][i] = temp;
      }
      bottom--;
      top++;
    }
  }

  private static void swapCol(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;
    int left = 0, right = col - 1;
    while (left <= right) {
      for (int i = 0; i < row; i++) {
        int temp = arr[i][right];
        arr[i][right] = arr[i][left];
        arr[i][left] = temp;
      }
      left++;
      right--;
    }
  }

  private static void printMatrix(int[][] arr1) {
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        System.out.print(arr1[i][j] + " ");
      }
      System.out.println();
    }
  }
}
