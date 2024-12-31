package gfg.a11_Stacks.course;

import java.util.Stack;

public class a10_LargestRectangleWith1s {
  public static void main(String[] args) {
    int[][] arr = {{1, 0, 0, 1, 1}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 1, 1, 1}};
    System.out.println("Largest rectangle with all 1's: " + maxRectangle(arr));
  }

  private static int maxRectangle(int[][] arr) {
    int res = largestHist(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 1) {
          arr[i][j] += arr[i - 1][j];
        }
      }
      res = Math.max(res, largestHist(arr[i]));
    }
    return res;
  }

  private static int largestHist(int[] arr) {
    Stack s = new Stack();
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!s.isEmpty() && arr[(int) s.peek()] >= arr[i]) {
        int tp = (int) s.pop();
        int curr = arr[tp] * (!s.isEmpty() ? (i - 1 - (int) s.peek()) : i);
        res = Math.max(res, curr);
      }
      s.push(i);
    }
    while (!s.isEmpty()) {
      int tp = (int) s.pop();
      int curr = arr[tp] * (s.isEmpty() ? arr.length : arr.length - 1 - (int) s.peek());
      res = Math.max(res, curr);
    }
    return res;
  }
}
