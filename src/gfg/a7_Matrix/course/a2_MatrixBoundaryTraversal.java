package gfg.a7_Matrix.course;

import java.util.ArrayList;

public class a2_MatrixBoundaryTraversal {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(printBoundaryTraversal(arr));
  }

  private static ArrayList<Integer> printBoundaryTraversal(int[][] arr) {
    ArrayList<Integer> res = new ArrayList<>();
    int row = arr.length;
    int col = arr[0].length;

    if (row == 1) {
      for (int i = 0; i < col; i++) {
        res.add(arr[0][i]);
      }
    } else if (col == 1) {
      for (int i = 0; i < row; i++) {
        res.add(arr[i][0]);
      }
    } else {
      // left to right
      for (int i = 0; i < col; i++) {
        res.add(arr[0][i]);
      }
      // top to bottom
      for (int i = 1; i < row; i++) {
        res.add(arr[i][col - 1]);
      }
      // right to left
      for (int i = col - 2; i >= 0; i--) {
        res.add(arr[row - 1][i]);
      }
      // bottom to top
      for (int i = row - 2; i >= 1; i--) {
        res.add(arr[i][0]);
      }
    }

    return res;
  }
}
