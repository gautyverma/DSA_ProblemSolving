package gfg.a7_Matrix.course;

public class a5_SpiralTraversalMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    printSpiralTraversal(arr);
  }

  private static void printSpiralTraversal(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;
    int top = 0, bottom = row - 1; // row pointer
    int left = 0, right = col - 1; // col pointer
    while (top <= bottom && left <= right) {
      // 1. top row after print increment it
      for (int i = left; i <= right; i++) {
        System.out.print(arr[top][i] + " ");
      }
      top++;
      // 2. right col after print decrement it
      for (int i = top; i <= bottom; i++) {
        System.out.print(arr[i][right] + " ");
      }
      right--;
      // check pointer not to cross each other
      if (top <= bottom) {
        // 3. bottom row after print decrement it
        for (int i = right; i >= left; i--) {
          System.out.print(arr[bottom][i] + " ");
        }
        bottom--;
      }
      if (left <= right) {
        // 4. left col after print increment it
        for (int i = bottom; i >= top; i--) {
          System.out.print(arr[i][left] + " ");
        }
        left++;
      }
    }
  }
}
