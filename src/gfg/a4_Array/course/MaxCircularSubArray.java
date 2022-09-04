package gfg.a4_Array.course;

public class MaxCircularSubArray {
  public static void main(String[] args) {
    //
    int[] arr = {5, -2, 3, 4};
    int[] arr1 = {8, -4, 3, -5, 4};
    System.out.println("Max Sum of circular sub-array Efficient: " + maxSumEff(arr1));
  }

  private static int maxSumEff(int[] arr) {

    /* int sum = 0;
      for (int i : arr) {
        sum += i;
      }
      int curr_min = arr[0], prev_min = arr[0];
      for (int i = 1; i < arr.length; i++) {
        prev_min = Math.min(arr[i], arr[i] + prev_min);
        curr_min = Math.min(curr_min, prev_min);
      }
      return sum - curr_min;
    }*/

    System.out.println("Efficient Approach : ");
    int kadaneSum = kadane(arr);
    if (kadaneSum < 0) {
      return kadaneSum;
    }
    int sum_arr = 0;
    for (int i = 0; i < arr.length; i++) {
      sum_arr += arr[i];
      arr[i] = -arr[i];
    }
    int max_circular = sum_arr + kadane(arr);
    return Math.max(kadaneSum, max_circular);
  }

  private static int kadane(int[] arr) {
    int curr_max = arr[0], prev_max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prev_max = Math.max(arr[i], prev_max + arr[i]);
      curr_max = Math.max(prev_max, curr_max);
    }
    return curr_max;
  }
}
