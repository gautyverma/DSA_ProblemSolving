package gfg.a4_Array.course;

public class WindowSlidingTechnique {
  public static void main(String[] args) {
    //
    int[] arr = {1, 8, 30, -5, 30};
    int k = 3;
    System.out.println(navieSol(arr, k));
    System.out.println(effSol(arr, k));

    int[] arr1 = {-5, -10, 6, 90, 3};
    int k1 = 2;
    System.out.println(navieSol(arr1, k1));
    System.out.println(effSol(arr1, k1));
  }

  private static int effSol(int[] arr, int k) {
    System.out.println("Efficient Sol");
    int res = Integer.MIN_VALUE;
    int curr = 0, first = 0;
    boolean flag = true;
    for (int i = 0; i < arr.length; i++) {
      if (i < k) {
        curr += arr[i];
      } else {
        first = arr[i - k];
        curr += arr[i] - first;
      }
      res = Math.max(res, curr);
    }
    return res;
  }

  private static int navieSol(int[] arr, int k) {
    System.out.println("Naive Solution -");
    int res = Integer.MIN_VALUE;
    for (int i = 0; i <= arr.length - k; i++) {
      int curr = 0;
      for (int j = i; j < i + k; j++) {
        curr += arr[j];
      }
      res = Math.max(res, curr);
    }
    return res;
  }
}
