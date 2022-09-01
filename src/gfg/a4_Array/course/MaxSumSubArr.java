package gfg.a4_Array.course;

public class MaxSumSubArr {
  public static void main(String[] args) {
    //
    int[] arr = {-5, 1, -2, 3, -1, 2, -2};
    int[] arr1 = {2, 3, -8, 7, -1, 2, -3};
    System.out.println("Max SubArr Sum Eff : " + maxSumSubArrEff(arr1));
    System.out.println("Max SubArr Sum Navie: " + maxSumSubArrNavie(arr1));
  }

  private static int maxSumSubArrNavie(int[] arr) {
    System.out.println("---- Navie Solution ----");
    int res = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int curr = 0;
      for (int j = i; j < arr.length; j++) {
        curr += arr[j];
        res = Math.max(curr,res);
      }
    }
    return res;
  }

  private static int maxSumSubArrEff(int[] arr) {
    System.out.println("---- Effective Solution ----");
    int currMax = arr[0], prevMax = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prevMax = Math.max(arr[i], prevMax + arr[i]);
      currMax = Math.max(prevMax, currMax);
    }

    return currMax;
  }
}
