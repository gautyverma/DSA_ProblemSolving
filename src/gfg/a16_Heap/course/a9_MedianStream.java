package gfg.a16_Heap.course;

import java.util.Collections;
import java.util.PriorityQueue;

public class a9_MedianStream {
  public static void main(String[] args) {

    int[] arr = {12, 15, 10, 5, 8, 7, 16};
    printMedians(arr);
  }

  private static void printMedians(int[] arr) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

    maxHeap.add(arr[0]);
    System.out.print(arr[0] + " ");

    for (int i = 1; i < arr.length; i++) {
      int x = arr[i];
      if (maxHeap.size() > minHeap.size()) {
        if (maxHeap.peek() > x) {
          minHeap.add(maxHeap.poll());
          maxHeap.add(x);
        } else minHeap.add(x);
        System.out.print((double) (maxHeap.peek() + minHeap.peek()) / 2 + " ");
      } else {
        if (x <= maxHeap.peek()) maxHeap.add(x);
        else {
          minHeap.add(x);
          maxHeap.add(minHeap.poll());
        }
        System.out.print(maxHeap.peek()+" ");
      }
    }
  }
}
