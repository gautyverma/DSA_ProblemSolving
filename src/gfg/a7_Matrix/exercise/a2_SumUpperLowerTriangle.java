package gfg.a7_Matrix.exercise;

import java.util.ArrayList;

public class a2_SumUpperLowerTriangle {
  public static void main(String[] args) {
    int[][] arr = {{6, 5, 4}, {1, 2, 5}, {7, 9, 7}};
    System.out.println("Sum of upper and lower :: " + sumTriangles(arr));
  }

  private static ArrayList<Integer> sumTriangles(int[][] arr) {
    ArrayList<Integer> res = new ArrayList<>();
    int upper = 0, lower = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (i == j) {
          upper += arr[i][j];
          lower += arr[i][j];
        } else if (i < j) {
          upper += arr[i][j];
        } else {
          lower += arr[i][j];
        }
      }
    }
    res.add(upper);
    res.add(lower);
    return res;
  }
}
