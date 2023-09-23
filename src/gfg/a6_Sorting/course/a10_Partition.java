package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a10_Partition {
  public static void main(String[] args) {
    int[] arr = {3, 8, 6, 12, 10, 7};
    navivePart(arr, 0, arr.length - 1, 5);
    System.out.println("Naive Solution: " + Arrays.toString(arr));

    int[] arr1 = {3, 8, 6, 12, 10, 7};
    lomutoPart(arr1, 0, arr1.length - 1);
    System.out.println("Lomuto Solution: " + Arrays.toString(arr1));

    int[] arr2 = {3, 8, 6, 12, 10, 7};
    hoarePart(arr2, 0, arr2.length - 1);
    System.out.println("Hoare Solution: " + Arrays.toString(arr2));
  }

  private static void hoarePart(int[] arr, int l, int h) {
    int temp = 0, i = l - 1, j = h + 1, pivot = arr[l];
    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);
      do {
        j--;
      } while (arr[j] > pivot);
      if (i >= j) break;
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  private static void lomutoPart(int[] arr, int l, int h) {
    int pivot = arr[h];
    int i = l - 1, temp = 0;
    for (int j = l; j <= h-1; j++) {
      if (arr[j] < pivot) {
        i++;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    temp = arr[i + 1];
    arr[i + 1] = arr[h];
    arr[h] = temp;
  }

  private static void navivePart(int[] arr, int l, int h, int p) {
    int[] temp = new int[h - l + 1];
    int index = 0;
    for (int i = l; i <= h; i++) {
      if (arr[i] <= arr[p]) {
        temp[index] = arr[i];
        index++;
      }
    }
    for (int i = l; i <= h; i++) {
      if (arr[i] > arr[p]) {
        temp[index] = arr[i];
        index++;
      }
    }
    for (int i = l; i <= h; i++) {
      arr[i] = temp[i - l];
    }
  }
}
