package gfg.a16_Heap.exercise;

import java.util.HashMap;
import java.util.PriorityQueue;

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
