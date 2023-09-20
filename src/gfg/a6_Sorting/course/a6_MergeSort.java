package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a6_MergeSort {
  public static void main(String[] args) {
    int[] arr = {64, 49, 43, 15, 8, 3, 7, 9, 3, 4, 95, 29, 46, 4, 45, 42, 1, 6};
    sortArray_merge(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void sortArray_merge(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
  }

  private static void mergeSort(int[] arr, int l, int r) {
    if (r > l) {
      int mid = l + (r - l) / 2;
      mergeSort(arr, 0, mid);
      mergeSort(arr, mid + 1, r);
      merge(arr, 0, mid, r);
    }
  }

  static void merge(int arr[], int low, int mid, int high) {

    int n1 = mid - low + 1, n2 = high - mid;
    int[] left = new int[n1];
    int[] right = new int[n2];
    for (int i = 0; i < n1; i++) left[i] = arr[i + low];
    for (int j = 0; j < n2; j++) right[j] = arr[mid + 1 + j];
    int i = 0, j = 0, k = low;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) arr[k++] = left[i++];
      else arr[k++] = right[j++];
    }
    while (i < n1) arr[k++] = left[i++];
    while (j < n2) arr[k++] = right[j++];
  }
  /*
    private void int[] merge(int[] arr, int low, int mid, int high) {
      int n = arr.length, index = 0, j = mid + 1;
      int[] res = new int[n];
      while (low <= mid && j <= high) {
        if (arr[low] <= arr[j]) {
          res[index] = arr[low];
          index++;
          low++;
        } else {
          res[index] = arr[j];
          index++;
          j++;
        }
      }
      while (low <= mid) {
        res[index] = arr[low];
        index++;
        low++;
      }
      while (j <= high) {
        res[index] = arr[j];
        index++;
        j++;
      }

      return res;
    }
  */
}
