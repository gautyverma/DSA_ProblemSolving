package gfg.a16_Heap.course;

import java.util.Arrays;

public class a3_HeapSort {
  public static void main(String[] args) {
    int[] arr = {
      4, 8, 6, 3, 1, 80, 41, 34, 8, 60,
    };
    heapSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void heapSort(int[] arr) {
    buildMaxHeap(arr, arr.length);

    for (int i = arr.length - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      maxHeapify(arr, i, 0);
    }
  }

  private static void buildMaxHeap(int[] arr, int n) {
    for (int i = (n - 2) / 2; i >= 0; i--) {
      maxHeapify(arr, n, i);
    }
  }

  private static void maxHeapify(int[] arr, int n, int i) {
    int largest = i, left = 2 * i + 1, right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) largest = left;
    if (right < n && arr[right] > arr[largest]) largest = right;

    if (largest != i) {
      int temp = arr[largest];
      arr[largest] = arr[i];
      arr[i] = temp;

      maxHeapify(arr, n, largest);
    }
  }
}
