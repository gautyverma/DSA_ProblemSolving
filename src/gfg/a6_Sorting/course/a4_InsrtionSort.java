package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a4_InsrtionSort {
  public static void main(String[] args) {
    int[] arr = {4, 7, 6, 5, 95, 72, 16, 1, 18};
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void insertionSort(int[] arr) {

    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
}
