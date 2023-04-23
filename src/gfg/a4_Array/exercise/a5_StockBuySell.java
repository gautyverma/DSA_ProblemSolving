package gfg.a4_Array.exercise;

import java.util.ArrayList;
/*
*
* The cost of stock on each day is given in an array A[] of size N.
* Find all the segments of days on which you buy and sell the stock
* so that in between those days  for which profit can be generated

  Example 1:

  Input:
  N = 7
  A[] = {100,180,260,310,40,535,695}
  Output:
  1
  Explanation:
  One possible solution is (0 3) (4 6)
  We can buy stock on day 0,
  and sell it on 3rd day, which will
  give us maximum profit. Now, we buy
  stock on day 4 and sell it on day 6.

  * Example 2:

  Input:
  N = 5
  A[] = {4,2,2,2,4}
  Output:
  1
  Explanation:
  There are multiple possible solutions.
  one of them is (3 4)
  We can buy stock on day 3,
  and sell it on 4th day, which will
  give us maximum profit.
* */

public class a5_StockBuySell {
  public static void main(String[] args) {
    //
    int arr[] = {100, 180, 260, 310, 40, 535, 695};
    ArrayList<ArrayList<Integer>> arrayLists = stockBuySell(arr, arr.length);
    System.out.println(arrayLists);

    int arr1[] = {4, 2, 2, 2, 4};
    System.out.println(stockBuySell(arr1, arr1.length));
  }

  static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
    // code here
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    int i = 0;
    while (i < n - 1) {
      ArrayList<Integer> innerList = new ArrayList<>();
      int startIndex = i;
      int endIndex = i;
      int p = 0;
      for (int j = i; j < n - 1; j++) {
        if (A[j] < A[j + 1]) {
          p += A[j + 1] - A[j];
          endIndex = j + 1;
          i++;
        } else {
          i = j + 1;
          break;
        }
      }
      if (startIndex != endIndex) {
        innerList.add(startIndex);
        innerList.add(endIndex);
        res.add(innerList);
      }
      //      i++;
    }
    return res;
  }
}
