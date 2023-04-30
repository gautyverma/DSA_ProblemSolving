package gfg.a4_Array.exercise;

import java.util.Arrays;

/*
Given a sorted array of positive integers. Your task is to rearrange the array elements alternatively
i.e first element should be max value, second should be min value, third should be second max,
fourth should be second min and so on.
Note: Modify the original array itself. Do it without using any extra space. You do not have to return anything.

    Example 1:

    Input:
    n = 6
    arr[] = {1,2,3,4,5,6}
    Output: 6 1 5 2 4 3
    Explanation: Max element = 6, min = 1,
    second max = 5, second min = 2, and
    so on... Modified array is : 6 1 5 2 4 3.

    Example 2:

    Input:
    n = 11
    arr[]={10,20,30,40,50,60,70,80,90,100,110}
    Output:110 10 100 20 90 30 80 40 70 50 60
    Explanation: Max element = 110, min = 10,
    second max = 100, second min = 20, and
    so on... Modified array is :
    110 10 100 20 90 30 80 40 70 50 60.
*/
public class a16_RearrangeArrayAlter {
  public static void main(String[] args) {
    //
    long[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
    rearrange(arr, arr.length);
    System.out.println(Arrays.toString(arr));

    long[] arr1 = {1, 2, 3, 4, 5, 6};
    rearrange(arr1, arr1.length);
    System.out.println(Arrays.toString(arr1));
  }

  public static void rearrange(long arr[], int n) {
    // Your code here
    int firstInd = 0;
    int lastInd = n - 1;
    int maxi = (int) arr[n - 1]+1;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        arr[i] += (arr[lastInd] % maxi) * maxi;
        lastInd--;
      } else {
        arr[i] += (arr[firstInd] % maxi) * maxi;
        firstInd++;
      }
    }
    for (int i = 0; i < n; i++) arr[i] /= maxi;
  }
}
