package gfg.a7_Matrix.course;

import java.util.Arrays;

public class a7_MedianOfRowSortedMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 10, 20}, {15, 25, 30}, {5, 8, 40}};
    System.out.println("Median of matirx ::" + matrixMedian(arr));
  }

  private static int matrixMedian(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    int min = arr[0][0], max = arr[0][col - 1];
    for (int i = 1; i < row; i++) {
      if (arr[i][0] < min) min = arr[i][0];
      if (arr[i][col - 1] < max) max = arr[i][col - 1];
    }
    int medPos = (row * col + 1) / 2;
    while (min < max) {
      int mid = (min + max) / 2, midPos = 0;
      for (int i = 0; i < row; i++) {
        int pos = Arrays.binarySearch(arr[i], mid) + 1;
        midPos += Math.abs(pos);
      }
      if (midPos < medPos) min = mid + 1;
      else max = mid;
    }

    return min;
  }
}
