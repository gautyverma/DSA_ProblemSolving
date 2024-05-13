package gfg.a6_Sorting.course;

import java.util.Arrays;

public class a16_MeetingMaxGuest {
  public static void main(String[] args) {
    int[] arrival = {900, 600, 700};
    int[] departure = {730, 800, 1000};
    System.out.println("Meeting max guests : " + maxGuests(arrival, departure, arrival.length));
  }

  private static int maxGuests(int[] arrival, int[] departure, int size) {
    Arrays.sort(arrival);
    Arrays.sort(departure);
    int i = 1, j = 0, res = 1, curr = 1;
    while (i < size && j < size) {
      if (arrival[i] <= departure[j]) {
        curr++;
        i++;
      } else {
        curr--;
        j++;
      }
      res = Math.max(res, curr);
    }
    return res;
  }
}
