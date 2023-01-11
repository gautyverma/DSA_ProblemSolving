package gfg.a4_Array.course;

public class MinConsGoupFlip {
  public static void main(String[] args) {
    //
    int[] arr = {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0};
    effSol(arr);
  }

  private static void effSol(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      if (arr[i] != arr[i - 1]) {
        if (arr[i] != arr[0]) System.out.print("From " + i + " to ");
        else System.out.println(i - 1 + " end");
      }
    }
    if (arr[n - 1] != arr[0]) {
      System.out.println(n - 1 + " end");
    }
  }
}
