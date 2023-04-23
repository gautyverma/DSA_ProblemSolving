package gfg.a4_Array.exercise;

/*
* Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number)
* which has the maximum sum and return its sum.


  Example 1:

  Input:
  N = 5
  Arr[] = {1,2,3,-2,5}
  Output:
  9
  Explanation:
  Max subarray sum is 9
  of elements (1, 2, 3, -2, 5) which
  is a contiguous subarray.

 */
public class a6_KadaneAlgo {
  public static void main(String[] args) {
    //
    int arr[] = {1, 2, 3, -2, 5};
    System.out.println(maxSubarraySum(arr, arr.length));
  }

  static long maxSubarraySum(int arr[], int n) {
    int prevMax = arr[0];
    int currMax = arr[0];
    for (int i = 1; i < n; i++) {
      prevMax = Math.max(arr[i], prevMax + arr[i]);
      currMax = Math.max(currMax, prevMax);
    }
    return currMax;
  }
}
