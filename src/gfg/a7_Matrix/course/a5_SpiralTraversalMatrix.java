package gfg.a7_Matrix.course;

import java.util.ArrayList;

public class a5_SpiralTraversalMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    System.out.println(spiralTraversal(arr));
  }

  private static ArrayList<Integer> spiralTraversal(int[][] arr) {
    ArrayList<Integer> res = new ArrayList<>();
    int row = arr.length;
    int col = arr[0].length;
    int top = 0, bottom = row - 1; // row pointer
    int left = 0, right = col - 1; // col pointer
    while (top <= bottom && left <= right) {
      // 1. top row after print increment it
      for (int i = left; i <= right; i++) {
        //        System.out.print(arr[top][i] + " ");
        res.add(arr[top][i]);
      }
      top++;
      // 2. right col after print decrement it
      for (int i = top; i <= bottom; i++) {
        //        System.out.print(arr[i][right] + " ");
        res.add(arr[i][right]);
      }
      right--;
      // check pointer not to cross each other
      if (top <= bottom) {
        // 3. bottom row after print decrement it
        for (int i = right; i >= left; i--) {
          //          System.out.print(arr[bottom][i] + " ");
          res.add(arr[bottom][i]);
        }
        bottom--;
      }
      if (left <= right) {
        // 4. left col after print increment it
        for (int i = bottom; i >= top; i--) {
          //          System.out.print(arr[i][left] + " ");
          res.add(arr[i][left]);
        }
        left++;
      }
    }
    return res;
  }
}
