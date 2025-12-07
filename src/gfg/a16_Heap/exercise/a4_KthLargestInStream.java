package gfg.a16_Heap.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
*
* Given an input stream of n integers, find the kth largest element each time when an new element is added to the stream.

Example 1:

Input:
k = 4, n = 6
arr[] = {1,2,3,4,5,6}
Output: -1 -1 -1 1 2 3
Explanation: k = 4
For 1, the 4th largest element doesn't
exist so we print -1.
For 2, the 4th largest element doesn't
exist so we print -1.
For 3, the 4th largest element doesn't
exist so we print -1.
For 4, the 4th largest element is 1
{1, 2, 3, 4}
For 5, the 4th largest element is 2
{2, 3, 4 ,5}
For 6, the 4th largest element is 3
{3, 4, 5, 6}
*
* */
public class a4_KthLargestInStream {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    int[] arr1 = {3, 4};

    System.out.println("=== Naive Solution ===");
    kthLargestNaive(arr, 4);
    System.out.println();
    kthLargestNaive(arr1, 1);

    System.out.println("\n=== Efficient Solution ===");
    kthLargestEff(arr, 4);
    System.out.println();
    kthLargestEff(arr1, 1);
  }

  private static void kthLargestEff(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {
      if (minHeap.size() < k) {
        minHeap.add(arr[i]);
      } else if (arr[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(arr[i]);
      }

      if (minHeap.size() == k) {
        System.out.print(minHeap.peek() + " ");
      } else {
        System.out.print(-1 + " ");
      }
    }
  }

  private static void kthLargestNaive(int[] arr, int k) {
    ArrayList<Integer> descList = new ArrayList<>();
    for (int i = 0; i < k - 1; i++) {
      descList.add(arr[i]);
      System.out.print(-1 + " ");
    }
    Collections.sort(descList, Collections.reverseOrder());
    for (int i = k - 1; i < arr.length; i++) {
      descList.add(arr[i]);
      Collections.sort(descList, Collections.reverseOrder());
      System.out.print(descList.get(k - 1) + " ");
    }
  }
}
