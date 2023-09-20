package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a5_MergeTwoSortedArray {
  public static void main(String[] args) {
    int[] a = {1, 8, 9};
    int[] b = {2, 4, 6, 7};
    int[] c = mergeTwoSort(a, b);
    System.out.println(Arrays.toString(c));
  }

  private static int[] mergeTwoSort(int[] a, int[] b) {

    int index = 0, i = 0, j = 0, n = a.length, m = b.length;
    int[] arrMerge = new int[n + m];
    while (i < n && j < m) {
      if (a[i] <= b[j]) {
        arrMerge[index] = a[i];
        i++;
        index++;
      } else {
        arrMerge[index] = b[j];
        j++;
        index++;
      }
    }
    while (i < n) {
      arrMerge[index] = a[i];
      i++;
      index++;
    }
    while (j < m) {

      arrMerge[index] = b[j];
      j++;
      index++;
    }
    return arrMerge;
  }
}
