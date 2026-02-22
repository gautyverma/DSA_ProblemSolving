package gfg.a18_Greedy.course;

import java.util.Arrays;

public class a3_jobSequences {

  static class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
      this.id = id;
      this.deadline = deadline;
      this.profit = profit;
    }
  }

  public static void main(String[] args) {
    Job arr[] = {
      new Job(1, 2, 100), new Job(2, 1, 50), new Job(3, 2, 10), new Job(4, 1, 20), new Job(5, 3, 30)
    };
    System.out.println("Max profit :: " + maxProfit(arr));
  }

  private static int maxProfit(Job[] arr) {

    // 1. Sort in decreasing order
    Arrays.sort(arr, (a, b) -> b.profit - a.profit);

    // Step 2: Find maximum deadline
    int maxDeadline = 0;
    for (Job job : arr) {
      maxDeadline = Math.max(maxDeadline, job.deadline);
    }

    // Step 3: Create slots
    int[] slot = new int[maxDeadline + 1];
    Arrays.fill(slot, -1);

    int totalProfit = 0;

    // Step 4: Schedule jobs
    for (Job job : arr) {
      for (int j = job.deadline; j > 0; j--) {
        if (slot[j] == -1) {
          slot[j] = job.id;
          totalProfit += job.profit;
          break;
        }
      }
    }
    return totalProfit;
  }
}
