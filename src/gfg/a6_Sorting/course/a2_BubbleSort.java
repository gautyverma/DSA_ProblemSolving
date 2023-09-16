package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a2_BubbleSort {
  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 8, 10, 69, 4, 2, 6, 9, 4};
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          //          swapNum(arr[j], arr[j + 1]);
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      if(swapped == false){
        break;
      }
    }
  }

  private static void swapNum(int a, int b) {
    a = a + b;
    b = a - b;
    a = a - b;
  }
}
