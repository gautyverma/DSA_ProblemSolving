package gfg.a16_Heap.course;

import java.util.Arrays;

public class a2_BuildHeap {
  public static void main(String[] args) {
    int[] arr = {10, 5, 20, 2, 4, 8};
    buildMinHeap(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(isHeap(arr));
  }

  private static boolean isHeap(int[] arr) {
    int n = arr.length;

    // Check only internal nodes (all parents)
    for (int i = 0; i <= (n - 2) / 2; i++) {

      // left child
      int left = 2 * i + 1;
      if (left < n && arr[i] > arr[left]) return false;

      // right child
      int right = 2 * i + 2;
      if (right < n && arr[i] > arr[right]) return false;
    }
    return true;
  }

  // Heapify a subtree rooted at index i in array arr[] of size n
  public static void minHeapify(int[] arr, int n, int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] < arr[smallest]) smallest = left;

    if (right < n && arr[right] < arr[smallest]) smallest = right;

    // If smallest is not the root, swap and continue heapifying
    if (smallest != i) {
      int temp = arr[i];
      arr[i] = arr[smallest];
      arr[smallest] = temp;

      minHeapify(arr, n, smallest);
    }
  }

  // Build a Min Heap from an array
  public static void buildMinHeap(int[] arr) {
    int n = arr.length;

    // Start from last internal node and heapify each
    for (int i = (n / 2) - 1; i >= 0; i--) {
      minHeapify(arr, n, i);
    }
  }
}
