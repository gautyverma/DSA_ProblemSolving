package gfg.a6_Sorting.course;

public class a8_UnionTwoSortedArrays {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4};
    int[] b = {5, 7, 9};
    printUnion(a, b);
  }

  private static void printUnion(int[] a, int[] b) {
    int n = a.length, m = b.length, i = 0, j = 0;
    while (i < n && j < m) {
      if (i > 0 && a[i] == a[i - 1]) {
        i++;
        continue;
      }
      if (j > 0 && b[j] == b[j - 1]) {
        j++;
        continue;
      }
      if (a[i] < b[j]) {
        System.out.print(a[i] + " ");
        i++;
      } else if (a[i] > b[j]) {
        System.out.print(b[j] + " ");
        j++;
      } else {
        System.out.print(a[i] + " ");
        i++;
        j++;
      }
    }
    while (i < n) {
      System.out.print(a[i] + " ");
      i++;
    }
    while (j < m) {
      System.out.print(b[j] + " ");
      j++;
    }
  }
}
