package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a11_QuickSort {
  public static void main(String[] args) {
    int[] arr = {9, 2, 8, 4, 6, 3, 1, 8, 4};
    quickSortLomuto(arr);
    System.out.println("QuickSort using Lomuto algorithm : " + Arrays.toString(arr));
  }

  private static void quickSortLomuto(int[] arr) {
    quickSortL(arr, 0, arr.length - 1);
  }

  private static void quickSortL(int[] arr, int l, int h) {
    if (l < h) {
      int pIndex = partionL(arr, l, h);
      quickSortL(arr, l, pIndex - 1);
      quickSortL(arr, pIndex + 1, h);
    }
  }

  private static int partionL(int[] arr, int l, int h) {
    int temp = 0, pivot = arr[h], i = l - 1;
    for (int j = l; j <= h - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    temp = arr[h];
    arr[h] = arr[i + 1];
    arr[i + 1] = temp;
    return i + 1;
  }
}
