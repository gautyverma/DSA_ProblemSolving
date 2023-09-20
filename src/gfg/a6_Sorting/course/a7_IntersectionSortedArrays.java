package gfg.a6_Sorting.course;

public class a7_IntersectionSortedArrays {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 3, 3, 4, 5, 7};
    int[] b = {1, 2, 3, 3, 3, 4, 5, 7};
    printIntersection(a, b);
  }

  private static void printIntersection(int[] a, int[] b) {
    int i = 0, j = 0, n = a.length, m = b.length;
    while (i < n && j < m) {
      if (i > 0 && a[i] == a[i - 1]) {
        i++;
        continue;
      }
      if (a[i] < b[j]) i++;
      else if (a[i] > b[j]) j++;
      else {
        System.out.print(a[i] + " ");
        i++;
        j++;
      }
    }
  }
}
