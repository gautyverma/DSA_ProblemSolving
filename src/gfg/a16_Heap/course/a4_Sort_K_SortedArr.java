package gfg.a16_Heap.course;

import java.util.Arrays;
import java.util.PriorityQueue;

public class a4_Sort_K_SortedArr {
  public static void main(String[] args) {
    int[] arr = {48, 93, 4, 88, 59, 62, 16, 41, 5, 41, 8};
    int k = 5;
    sortKSortedArr(arr, k);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {9,8,7,18,19,17};
    int k1 = 2;
    sortKSortedArr(arr1, k1);
    System.out.println(Arrays.toString(arr1));

  }

  private static void sortKSortedArr(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i <= k; i++) {
      pq.add(arr[i]);
    }
    int index = 0;
    for (int i = k + 1; i < arr.length; i++) {
      arr[index] = pq.poll();
      index++;
      pq.add(arr[i]);
    }

    while (!pq.isEmpty()) arr[index++] = pq.poll();
  }
}
