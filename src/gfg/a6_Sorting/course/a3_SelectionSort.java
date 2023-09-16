package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a3_SelectionSort {
  public static void main(String[] args) {
    int[] arr = {4, 6, 4, 1, 3, 8, 14, 41, 96};
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minInd = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minInd]) {
          int temp = arr[j];
          arr[j] = arr[minInd];
          arr[minInd] = temp;
        }
      }
    }
  }
}
