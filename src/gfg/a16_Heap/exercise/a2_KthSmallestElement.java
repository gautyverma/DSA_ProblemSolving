package gfg.a16_Heap.exercise;

import java.util.Collections;
import java.util.PriorityQueue;

public class a2_KthSmallestElement {
  public static void main(String[] args) {
    int[] arr = {3, 4, 5, 2, 9};
    System.out.println("Kth SmallestElement- " + kthSmallElement(arr, 3));
    System.out.println("Kth LargestElement- " + kthLargestElement(arr, 2));
  }

  private static int kthLargestElement(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      pq.add(arr[i]);
    }

    for (int i = k; i < arr.length; i++) {
      if (pq.peek() < arr[i]) {
        pq.poll();
        pq.add(arr[i]);
      }
    }
    return pq.peek();
  }

  private static int kthSmallElement(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < k; i++) {
      pq.add(arr[i]);
    }

    for (int i = k; i < arr.length; i++) {
      if (pq.peek() > arr[i]) {
        pq.poll();
        pq.add(arr[i]);
      }
    }
    return pq.peek();
  }
}
