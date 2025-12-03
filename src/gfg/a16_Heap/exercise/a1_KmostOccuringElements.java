package gfg.a16_Heap.exercise;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
* Given an array arr[] in which elements may be repeating several times.
* Also, a positive number k is given and the task is to find sum of total frequencies of k most occurring elements.

Note: The value of k is guaranteed to be less than or equal to the number of distinct elements in arr.

Examples :

Input: arr[] = [3, 1, 4, 4, 5, 2, 6, 1], k = 2
Output: 4

* Explanation: Here, 4 and 1 are 2 most occurring elements in the array,
* both appearing twice. So, total sum of thier frequencies is 2 + 2 = 4.
Input: arr[] = [3, 3, 3, 4, 1, 1, 6, 1], k = 2
Output: 6
Explanation: Here, 3 and 1 are 2 most frequent elements in the array,
* both appearing three times. Hence, the total sum of their frequencies is 3 + 3 = 6.
* */

public class a1_KmostOccuringElements {
  public static void main(String[] args) {
    int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
    System.out.println(kMostFreqSum(arr, 2));
  }

  private static int kMostFreqSum(int[] arr, int k) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int num : arr) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int f : freq.values()) {
      minHeap.add(f);

      // Keep only k elements in heap
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    // Step 3: Sum k largest frequencies
    int sum = 0;
    while (!minHeap.isEmpty()) {
      sum += minHeap.poll();
    }

    return sum;
  }
}
