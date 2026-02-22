package gfg.a18_Greedy.course;

import java.util.Arrays;

public class a2_Knapsack {
  static class Item {
    int value, weight;

    Item(int v, int w) {
      value = v;
      weight = w;
    }
  }

  public static void main(String[] args) {
    Item arr[] = {new Item(600, 50), new Item(500, 20), new Item(400, 30)};
    int capacity = 70;
    System.out.println("Max value in knapsack :: "+fracKnapsack(arr,capacity));
  }

  private static double fracKnapsack(Item[] arr, int capacity) {

    // Sort by value/weight ratio descending
    Arrays.sort(arr, (a, b) ->
            Double.compare((double)b.value / b.weight,
                    (double)a.value / a.weight)
    );
    double totalValue = 0.0;
    int remainingCapacity = capacity;

    for (Item item : arr) {
      if (remainingCapacity == 0)
        break;

      if (item.weight <= remainingCapacity) {
        totalValue += item.value;
        remainingCapacity -= item.weight;
      } else {
        double fraction =
                (double) remainingCapacity / item.weight;
        totalValue += item.value * fraction;
        remainingCapacity = 0;
      }
    }

    return totalValue;
  }
}
