package gfg.a20_DynamicProgramming.course;

import java.util.Arrays;

public class a7_BuildingBridges {
  static class Bridge implements Comparable<Bridge> {
    int north;
    int south;

    Bridge(int north, int south) {
      this.north = north;
      this.south = south;
    }

    @Override
    public int compareTo(Bridge other) {
      if (this.north != other.north) return this.north - other.north;
      return this.south - other.south;
    }
  }

  public static void main(String[] args) {
    int[] north = {6, 4, 2, 1};
    int[] south = {2, 3, 6, 5};

    System.out.println("Maximum Non-Crossing Bridges: " + maxBridges(north, south));
  }

  public static int maxBridges(int[] north, int[] south) {
    int n = north.length;

    Bridge[] bridges = new Bridge[n];
    for (int i = 0; i < n; i++) {
      bridges[i] = new Bridge(north[i], south[i]);
    }

    // Step 1: Sort bridges
    Arrays.sort(bridges);

    // Step 2: Apply LIS on south values
    int[] tail = new int[n];
    int len = 0;

    for (int i = 0; i < n; i++) {
      int currSouth = bridges[i].south;

      int idx = Arrays.binarySearch(tail, 0, len, currSouth);

      if (idx < 0) {
        idx = -(idx + 1); // insertion point
      }

      tail[idx] = currSouth;

      if (idx == len) {
        len++;
      }
    }

    return len;
  }
}
