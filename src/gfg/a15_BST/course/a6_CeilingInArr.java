package gfg.a15_BST.course;

import java.util.TreeSet;

public class a6_CeilingInArr {

  public static void main(String[] args) {
    int[] arr = {2, 8, 30, 15, 25, 12};
    System.out.println("\n-- Naive solution --");
    naiveCeil(arr);
    System.out.println("\n-- Eff solution --");
    effCeilUsingTree(arr);
  }

  private static void effCeilUsingTree(int[] arr) {
    int n = arr.length;
    if (n == 0) return;

    System.out.print(-1 + " "); // first element has no ceil
    TreeSet<Integer> s = new TreeSet<>();
    s.add(arr[0]);

    for (int i = 1; i < n; i++) {
      Integer ceil = s.ceiling(arr[i]);
      if (ceil != null) System.out.print(ceil + " ");
      else System.out.print(-1 + " ");

      s.add(arr[i]);
    }
  }

  private static void naiveCeil(int[] arr) {
    int n = arr.length;
    if (n == 0) {
      return;
    }
    System.out.print(-1 + " ");
    for (int i = 1; i < n; i++) {
      int diff = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (arr[j] >= arr[i]) diff = Math.min(diff, arr[j] - arr[i]);
      }
      if (diff == Integer.MAX_VALUE) System.out.print(-1 + " ");
      else System.out.print(arr[i] + diff + " ");
    }
  }
}
