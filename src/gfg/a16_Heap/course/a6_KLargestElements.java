package gfg.a16_Heap.course;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class a6_KLargestElements {
  public static void main(String[] args) {
    int[] arr = {5, 15, 10, 20, 8};
    int k = 2;
    System.out.println(kLargestElements(arr, k));

    arr = new int[] {5, 15, 10, 20, 8, 25, 18};
    k = 3;
    System.out.println(kLargestElements(arr, k));
  }

  private static ArrayList<Integer> kLargestElements(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      pq.add(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      if (arr[i] > pq.peek()) {
        pq.poll();
        pq.add(arr[i]);
      }
    }
    ArrayList<Integer> list = new ArrayList<>();
    while (!pq.isEmpty()) {
      list.add(pq.poll());
    }
    return list;
  }
}
