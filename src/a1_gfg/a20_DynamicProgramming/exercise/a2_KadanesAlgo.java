package a1_gfg.a20_DynamicProgramming.exercise;

public class a2_KadanesAlgo {
  public static void main(String[] args) {
    int[] arr = {-9, -8, 8, 3, -4};
    System.out.println("Max sum of sub array (naive sol) :: " + sumSubArrNaive(arr, arr.length));
    System.out.println("Max sum of sub array (Dp sol) :: " + sumSubArrDp(arr, arr.length));
    System.out.println(
        "Max sum of no adjacent elements (Dp sol) :: " + sumSubArrDp2(arr, arr.length));
    System.out.println(
        "Max sum of no adjacent elements (most optimized Dp sol) :: "
            + sumSubArrDp3(arr, arr.length));
  }

  private static int sumSubArrDp3(int[] arr, int n) {
    if (n == 0) return 0;

    int evenPrev = Integer.MIN_VALUE;
    int evenMax = Integer.MIN_VALUE;

    int oddPrev = Integer.MIN_VALUE;
    int oddMax = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {

      if (i % 2 == 0) { // even index
        if (evenPrev == Integer.MIN_VALUE) evenPrev = arr[i];
        else evenPrev = Math.max(arr[i], evenPrev + arr[i]);

        evenMax = Math.max(evenMax, evenPrev);
      } else { // odd index
        if (oddPrev == Integer.MIN_VALUE) oddPrev = arr[i];
        else oddPrev = Math.max(arr[i], oddPrev + arr[i]);

        oddMax = Math.max(oddMax, oddPrev);
      }
    }

    return Math.max(evenMax, oddMax);
  }

  private static int sumSubArrDp2(int[] arr, int n) {
    if (n == 0) return 0;

    int size = 0;
    if (n % 2 != 0) size = n / 2 + 1;
    else size = n / 2;

    int[] temp1 = new int[size];
    int[] temp2 = new int[n - size];
    int j = 0;
    for (int i = 0; i < n; i = i + 2) {
      temp1[j] = arr[i];
      if (i + 1 < n - 1) temp2[j] = arr[i + 1];
      j++;
    }
    return Math.max(sumSubArrDp(temp1, size), sumSubArrDp(temp2, n - size));
  }

  private static int sumSubArrDp(int[] arr, int n) {
    if (n == 0) return 0;
    int prevSum = arr[0];
    int currSum = arr[0];
    for (int i = 1; i < n; i++) {
      prevSum = Math.max(arr[i], prevSum + arr[i]);
      currSum = Math.max(prevSum, currSum);
    }
    return currSum;
  }

  private static long sumSubArrNaive(int[] arr, int n) {
    if (n == 0) return 0;
    long res = arr[0];
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += arr[k];
        }
        res = Math.max(res, sum);
      }
    }
    return res;
  }
}
