package gfg.a4_Array.exercise;
/*
* Given an array Arr of n integers arranged in a circular fashion.
* Your task is to find the minimum absolute difference between adjacent elements.

    Example 1:

    Input:
    n = 7
    Arr[] = {8,-8,9,-9,10,-11,12}
    Output: 4
    Explanation: The absolute difference
    between adjacent elements in the given
    array are as such: 16 17 18  19 21 23 4
    (first and last). Among the calculated
    absolute difference the minimum is 4.
    Example 2:

    Input:
    n = 8
    Arr[] = {10,-3,-4,7,6,5,-4,-1}
    Output: 1
    Explanation: The absolute difference
    between adjacent elements in the given
    array are as such: 13 1 11 1 1 9 3 11
    (first and last).  Among the calculated
    absolute difference, the minimum is 1.
*/
public class a8_MaxAdjDiff {
  public static void main(String[] args) {
    //
    int arr[] = {8, -8, 9, -9, 10, -11, 12};
    System.out.println(minAdjDiff(arr, arr.length));

    int arr1[] = {10, -3, -4, 7, 6, 5, -4, -1};
    System.out.println(minAdjDiff(arr1, arr1.length));
  }

  public static int minAdjDiff(int arr[], int n) {
    // Your code here
    int minDiff = Math.abs(arr[n - 1] - arr[0]);
    for (int i = 0; i < n - 1; i++) {
      minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i + 1]));
    }
    return minDiff;
  }
}
