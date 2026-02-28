package gfg.a20_DynamicProgramming.course;

public class a5_MaxLengthBitonicSubsequence {
  public static void main(String[] args) {
    int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
    System.out.println("----------------------------");
    System.out.println("dp app with O(n^2) :: " + maxLengthBitonic(arr));
    System.out.println("----------------------------");
  }

  private static int maxLengthBitonic(int[] arr) {
    int[] lis = getLis(arr);
    int[] dis = getDis(arr);
    int res = lis[0] + dis[0] - 1;
    for (int i = 1; i < arr.length; i++) {
      res = Math.max(res, lis[i] + dis[i] - 1);
    }
    return res;
  }

  private static int[] getDis(int[] arr) {
    int n = arr.length;
    int[] dis = new int[n];
    dis[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      dis[i] = 1;
      for (int j = n - 1; j >= i; j--) {
        if (arr[j] < arr[i]) {
          dis[i] = Math.max(dis[i], dis[j] + 1);
        }
      }
    }
    return dis;
  }

  private static int[] getLis(int[] arr) {

    int[] lis = new int[arr.length];
    lis[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          lis[i] = Math.max(lis[i], lis[j] + 1);
        }
      }
    }
    return lis;
  }
}
