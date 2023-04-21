package gfg.a4_Array.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
* Given an unsorted array arr[] of size N.
* Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive integer.

    Example 1:

    Input:
    N = 5, D = 2
    arr[] = {1,2,3,4,5}
    Output: 3 4 5 1 2
    Explanation: 1 2 3 4 5  when rotated
    by 2 elements, it becomes 3 4 5 1 2.
 */
public class a3_RotateArray {
  public static void main(String[] args) {
    //
    int[] arr = {1, 2, 3, 4, 5};
    rotateArr(arr, 2, arr.length);
  }

  private static void rotateArr(int[] arr, int d, int n) {
    reverse(arr, 0, d - 1);
    reverse(arr, d, n - 1);
    reverse(arr, 0, n - 1);
    System.out.println(Arrays.toString(arr));
  }

  static void reverse(int[] arr, int i, int j) {
    while (i < j) {
      arr[i] = arr[i] + arr[j];
      arr[j] = arr[i] - arr[j];
      arr[i] = arr[i] - arr[j];
      i++;
      j--;
      ArrayList<Integer> a = new ArrayList<>();
      Collections.reverse(a);
    }
  }
}
