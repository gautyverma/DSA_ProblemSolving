package gfg.a16_Heap.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class a7_KClosestElements {
  public static void main(String[] args) {
    int[] arr = {10, 15, 7, 3, 4};

    System.out.println(kClosestElements(arr, 2, 8));
    arr = new int[] {30, 40, 32, 33, 36, 37};
    System.out.println(kClosestElements(arr, 3, 38));
  }

  private static ArrayList<Integer> kClosestElements(int[] arr, int k, int x) {
    ArrayList<Integer> res = new ArrayList<>();
    PriorityQueue<MyPair> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < k; i++) {
      pq.add(new MyPair(Math.abs(arr[i] - x), i));
    }
    for (int i = k; i < arr.length; i++) {
      Integer diff = Math.abs(arr[i] - x);
      if (pq.peek().diff > diff) {
        pq.remove();
        pq.add(new MyPair(diff, i));
      }
    }
    while (!pq.isEmpty()) {
      res.add(arr[pq.poll().index]);
    }
    return res;
  }
}

class MyPair implements Comparable<MyPair> {
  Integer diff, index;

  MyPair(Integer d, Integer i) {
    diff = d;
    index = i;
  }

  @Override
  public int compareTo(MyPair o) {
    return this.diff - o.diff;
  }
}
