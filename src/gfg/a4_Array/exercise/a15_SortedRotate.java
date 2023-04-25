package gfg.a4_Array.exercise;
/*
*
* Given an array arr[] of N distinct integers, check if this array is Sorted (non-increasing or non-decreasing)
* and Rotated counter-clockwise. Note that input array may be sorted in either increasing or decreasing order,
* then rotated.
* A sorted array is not considered as sorted and rotated, i.e., there should be at least one rotation.

    Example 1:

    Input:
    N = 4
    arr[] = {3,4,1,2}
    Output: Yes
    Explanation: The array is sorted
    (1, 2, 3, 4) and rotated twice
    (3, 4, 1, 2).
    Example 2:

    Input:
    N = 3
    arr[] = {1,2,3}
    Output: No
    Explanation: The array is sorted
    (1, 2, 3) is not rotated.
* */
public class a15_SortedRotate {
  public static void main(String[] args) {

    int[] arr = {3, 4, 1, 2};
    System.out.println(checkRotatedAndSorted(arr, arr.length));

    int[] arr1 = {10, 20, 14};
    System.out.println(checkRotatedAndSorted(arr1, arr1.length));

    int[] arr2 = {30, 20, 10, 50, 35};
    System.out.println(checkRotatedAndSorted(arr2, arr2.length));
  }

  public static boolean checkRotatedAndSorted(int arr[], int num) {
    boolean res = false;
    for (int i = 0; i < 2; i++) {
      rotateArrayByOne(arr, num);
      if (num > 1) {
        if (arr[0] < arr[1]) {
          res = isSortedIn(arr);
        } else {
          res = isSortedDec(arr);
        }
      }
      if (res) {
        return res;
      }
    }
    return res;
  }

  public static void rotateArrayByOne(int arr[], int n) {
    int temp = arr[0];
    for (int i = 1; i < n; i++) {
      arr[i - 1] = arr[i];
    }
    arr[n - 1] = temp;
  }

  public static boolean isSortedIn(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public static boolean isSortedDec(int arr[]) {
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] > arr[i - 1]) {
        return false;
      }
    }
    return true;
  }
}
