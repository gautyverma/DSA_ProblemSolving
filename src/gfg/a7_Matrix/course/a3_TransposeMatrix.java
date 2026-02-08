package gfg.a7_Matrix.course;

import java.util.ArrayList;

public class a3_TransposeMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
    System.out.println(transpose(arr));
  }

  public static ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    // result will be col x row
    for (int j = 0; j < col; j++) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (int i = 0; i < row; i++) {
        temp.add(mat[i][j]);
      }
      res.add(temp);
    }
    return res;
  }
}
