package gfg.a6_Sorting.course;

import java.util.Arrays;

class Interval implements Comparable<Interval> {

  int s, e;

  public Interval(int s, int e) {
    this.s = s;
    this.e = e;
  }

  @Override
  public int compareTo(Interval object) {
    return this.s - object.s;
  }
}

public class a15_MergeOverlappingIntervals {
  public static void main(String[] args) {
    Interval[] arr = {
      new Interval(5, 10),
      new Interval(2, 3),
      new Interval(6, 8),
      new Interval(1, 7),
      new Interval(18, 30)
    };
    mergeIntervals(arr);
  }

  private static void mergeIntervals(Interval[] arr) {

    Arrays.sort(arr);
    int n = arr.length, res = 0;
    for (int i = 1; i < n; i++) {
      if (arr[res].e >= arr[i].s) {
        arr[res].e = Math.max(arr[res].e, arr[i].e);
        arr[res].s = Math.min(arr[res].s, arr[i].s);
      } else {
        res++;
        arr[res] = arr[i];
      }
    }
    for (int i = 0; i <= res; i++) System.out.print("[" + arr[i].s + ", " + arr[i].e + "] ");
  }
}
