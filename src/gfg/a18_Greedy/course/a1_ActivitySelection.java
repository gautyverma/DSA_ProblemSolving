package gfg.a18_Greedy.course;

import java.util.Arrays;

public class a1_ActivitySelection {
  static class Activity {
    int start;
    int finish;

    Activity(int s, int f) {
      start = s;
      finish = f;
    }
  }

  public static void main(String[] args) {
    Activity arr[] = {
      new Activity(3, 8), new Activity(2, 4), new Activity(1, 3), new Activity(10, 11)
    };
    System.out.println("Max activities :: " + maxActivity(arr));
  }

  private static int maxActivity(Activity[] arr) {
    int n = arr.length;
    if (n == 0) return 0;
    Arrays.sort(arr, (a, b) -> a.finish - b.finish);
    int count = 1;
    int lastFinish = arr[0].finish;
    for (int i = 1; i < n; i++) {
      if (arr[i].start >= lastFinish) {
        count++;
        lastFinish = arr[i].finish;
      }
    }
    return count;
  }
}
