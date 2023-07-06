package gfg.a4_Array.exercise;

public class a19_LongestSubArrOddEven {
  public static void main(String[] args) {
    int[] arr = {10, 12, 14, 7, 8};
    System.out.println(maxEvenOdd(arr));
  }

  private static int maxEvenOdd(int[] arr) {
    int count = 1, max = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] % 2 !=  arr[i] % 2 ) {
        count++;
      } else {
        count=1;
      }
      max = Math.max(count, max);
    }
    return max;
  }
}
