package gfg.a4_Array.exercise;
/*
* You are given an array arr[] of N integers including 0.
* The task is to find the smallest positive number missing from the array.

    Example 1:

    Input:
    N = 5
    arr[] = {1,2,3,4,5}
    Output: 6
    Explanation: Smallest positive missing
    number is 6.
* */
public class a17_SmallestPositiveMissingNumber {
  public static void main(String[] args) {
    //
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    System.out.println(missingNumber(arr, arr.length));

    int arr1[] = {0, -10, 1, 3, -20};
    System.out.println(missingNumber(arr1, arr1.length));

    int arr2[] = {28, 7, -36, 21, -21, -50, 9, -32};
    System.out.println(missingNumber(arr2, arr2.length));
  }

  static int missingNumber(int arr[], int size) {
    // Your code here
    boolean arr1[] = new boolean[100001];
    // Initialize to false containing array
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = false;
    }
    for (int i = 0; i < size; i++) {
      if (arr[i] >= 0) {
        arr1[arr[i]] = true;
      }
    }
    arr1[0] = true;
    int i;
    for (i = 0; i < arr1.length; i++) {
      if (arr1[i] == false) {
        return i;
      }
    }
    if (i == arr1.length) {
      return i;
    }
    return -1;
  }
}
