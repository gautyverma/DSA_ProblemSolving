package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a6_MergeFunction {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 11, 7, 8, 9};
    int[] res = merge(arr, 0, 3, 6);
    System.out.println(Arrays.toString(res));
  }

  private static int[] merge(int[] arr, int low, int mid, int high) {
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
    while (low<=mid){
        res[index] = arr[low];
        index++;
        low++;
    }
    while(j<=high){
        res[index] = arr[j];
        index++;
        j++;
    }

    return res;
  }
}
