package gfg.a7_Matrix.course;

import java.util.ArrayList;

public class a1_SnakePattern {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(printSnakePattern(arr));
  }

  private static ArrayList<Integer> printSnakePattern(int[][] arr) {
    ArrayList<Integer> res = new ArrayList<>();
    int row = arr.length;
    int col = arr[0].length;
    for (int i = 0; i < row; i++) {
      if (i % 2 == 0) {
        for (int j = 0; j < col; j++) {
          res.add(arr[i][j]);
        }
      } else {
        for (int j = col - 1; j >= 0; j--) {
          res.add(arr[i][j]);
        }
      }
    }
    return res;
  }
}
