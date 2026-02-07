package gfg.a7_Matrix.course;

public class a6_SearchInSortedRowColMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    searchX(arr, 11);
    searchX(arr, 31);
  }

  private static void searchX(int[][] arr, int x) {
    int row = arr.length;
    int col = arr[0].length;

    int i = 0, j = col - 1;
    while (i < row && j >= 0) {
      if (arr[i][j] == x) {
        System.out.println(x + " found at arr[" + i + "][" + j + "]");
        return;
      } else if (arr[i][j] > x) {
        j--;
      } else {
        i++;
      }
    }
    System.out.println(x + " not found in arr");
  }
}
