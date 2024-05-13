package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a17_CycleSortDistinct {
  public static void main(String[] args) {
    int[] arr = {20, 10, 40, 50, 30};
    cycleSortDistinct(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void cycleSortDistinct(int[] arr) {
    int n = arr.length;
    for (int cs = 0; cs < n - 1; cs++) {
      int item = arr[cs];
      int pos = cs;
      for (int i = cs + 1; i < n; i++) {
        if (arr[i] < item) {
          pos++;
        }
      }
      // swap(item,arr[pos])
      int temp = item;
      item = arr[pos];
      arr[pos] = temp;

      while (pos != cs) {
        pos = cs;
        for (int i = cs + 1; i < n; i++) {
          if (arr[i] < item) {
            pos++;
          }
        }
        // swap(item,arr[pos])
        temp = item;
        item = arr[pos];
        arr[pos] = temp;
      }
    }
  }
}
