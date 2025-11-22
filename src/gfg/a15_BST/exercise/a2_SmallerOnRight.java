package gfg.a15_BST.exercise;

import java.util.TreeSet;

/*
*
* Given an array arr[] of N elements. The task is to count maximum number of
* distinct smaller elements on right side of any array element.
* For example, in {10, 6, 9, 7, 20, 19, 21, 18, 17, 16}, the result is 4.
* Note that 20 has maximum 4 smaller elements on right side. Other elements have less count, for example 10 has 3 smaller elements on right side.

Example:


Input:
4
10
10 6 9 7 20 19 21 18 17 16
5
5 4 3 2 1
5
1 2 3 4 5
5
1 2 3 2 1

Output:
4
4
0
2

Explanation:

Testcase 1: Number of smaller elements on right side of every element (from left to right)
 in the array are 3 0 1 0 4 3 3 2 1 and 0 respecitvely. Maximum of all these counts is 4.
Testcase 2: Number of smaller elements on right side of every element (from left to right)
in the array are 4 3 2 1 and 0 respecitvely. Maximum of all these counts is 4.
* */
public class a2_SmallerOnRight {
  public static void main(String[] args) {
    int arr1[] = {10, 6, 9, 7, 20, 19, 21, 18, 17, 16};
    System.out.println(maxDistinctSmallerRight(arr1));
  }

  private static int maxDistinctSmallerRight(int[] arr) {
    TreeSet<Integer> seen = new TreeSet<>();
    int maxCount = 0;

    // Traverse from right to left
    for (int i = arr.length - 1; i >= 0; i--) {
      int val = arr[i];

      // Count of distinct smaller elements
      int count = seen.headSet(val).size();
      maxCount = Math.max(maxCount, count);

      // Add current element to set
      seen.add(val);
    }
    return maxCount;
  }
}
