package gfg.a18_Greedy.exercise;

import java.util.Arrays;

public class a1_NMeetsInOneRoom {

  static class Time {
    int start, end;

    public Time(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) {
    int start[] = {1, 3, 0, 5, 8, 5}, end[] = {2, 4, 6, 7, 9, 9};
    System.out.println("Max meeting in one room :: " + maxMeetings(start, end));

    int start1[] = {7, 18, 24},end1[] = {30, 26, 28};
    System.out.println("Max meeting in one room :: " + maxMeetings(start1, end1));
  }

  private static int maxMeetings(int[] start, int[] end) {
    int n = start.length;
    if (n == 0) return 0;
    Time arr[] = new Time[n];

    // step - 1 pair setup
    for (int i = 0; i < n; i++) {
      arr[i] = new Time(start[i], end[i]);
    }

    // step - 2 sort in increasing order of end time of meet
    Arrays.sort(arr, (a,b) -> a.end - b.end);

    int count = 1 , lastEndMeetTime = arr[0].end;

    for(int i = 1;i<n;i++){
      if(arr[i].start > lastEndMeetTime){
        count++;
        lastEndMeetTime = arr[i].end;
      }
    }
    return count;
  }
}
