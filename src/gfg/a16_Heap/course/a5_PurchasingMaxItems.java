package gfg.a16_Heap.course;

import java.util.PriorityQueue;

public class a5_PurchasingMaxItems {
  public static void main(String[] args) {
    int[] arr = {1, 12, 5, 111, 200};
    int sum = 10;
    System.out.println("Max item purchased : " + maxItemPurchase(arr, sum));
  }

  private static int maxItemPurchase(int[] arr, int sum) {
    int res = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int obj : arr) {
      pq.add(obj);
    }
    while (!pq.isEmpty() && sum >= 0) {
      int curr = pq.poll();
      sum -= curr;
      if (sum >= 0) {
        res++;
      }
    }
    return res;
  }
}
