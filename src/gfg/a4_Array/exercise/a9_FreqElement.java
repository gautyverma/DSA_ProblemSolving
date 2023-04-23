package gfg.a4_Array.exercise;

import java.util.Arrays;
import java.util.TreeMap;

/*
Given an array A[] of N positive integers which can contain integers from 1 to P
where elements can be repeated or can be absent from the array.
Your task is to count the frequency of all elements from 1 to N.
Note: The elements greater than N in the array can be ignored for counting and do modify the array in-place.


    Example 1:

    Input:
    N = 5
    arr[] = {2, 3, 2, 3, 5}
    P = 5
    Output:
    0 2 2 0 1
    Explanation:
    Counting frequencies of each array element
    We have:
    1 occurring 0 times.
    2 occurring 2 times.
    3 occurring 2 times.
    4 occurring 0 times.
    5 occurring 1 time.
    Example 2:

    Input:
    N = 4
    arr[] = {3,3,3,3}
    P = 3
    Output:
    0 0 4 0
    Explanation:
    Counting frequencies of each array element
    We have:
    1 occurring 0 times.
    2 occurring 0 times.
    3 occurring 4 times.
    4 occurring 0 times.
*/
public class a9_FreqElement {
  public static void main(String[] args) {
    //
    int[] arr = {2, 3, 2, 3, 5};
    frequencyCount(arr, arr.length, 5);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {3, 3, 3, 3};
    frequencyCount(arr1, arr1.length, 3);
    System.out.println(Arrays.toString(arr1));
  }

  public static void frequencyCount(int arr[], int N, int P) {
    // code here
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i : arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (int i = 0, j = 1; i < N; i++, j++) {
      if (map.containsKey(j)) {
        arr[i] = map.get(j);
      } else {
        arr[i] = 0;
      }
    }
  }
}
