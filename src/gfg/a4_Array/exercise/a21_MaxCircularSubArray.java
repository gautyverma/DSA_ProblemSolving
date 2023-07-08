package gfg.a4_Array.exercise;
/*
*
* Given an array arr[] of N integers arranged in a circular fashion.
* Your task is to find the maximum contiguous subarray sum.

Example 1:

Input:
N = 7
arr[] = {8,-8,9,-9,10,-11,12}
Output:
22
Explanation:
Starting from the last element
of the array, i.e, 12, and
moving in a circular fashion, we
have max subarray as 12, 8, -8, 9,
-9, 10, which gives maximum sum
as 22.
Example 2:

Input:
N = 8
arr[] = {10,-3,-4,7,6,5,-4,-1}
Output:
23
Explanation: Sum of the circular
subarray with maximum sum is 23

Your Task:
The task is to complete the function circularSubarraySum() which returns a sum of the circular subarray with maximum sum.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
* */
public class a21_MaxCircularSubArray {
  public static void main(String[] args) {
    //
    int[] arr = {-5,1,-2,3,-1,2,-2};
    int[] arr1 = {8, -4, 3, -5, 4};
    System.out.println("Max Sum of circular sub-array Efficient: " + maxSumEff(arr1));
    System.out.println("Max Sum of circular sub-array Efficient: " + maxSumEff(arr));
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
