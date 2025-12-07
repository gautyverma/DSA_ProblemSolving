package gfg.a16_Heap.exercise;

import java.util.PriorityQueue;

/*
* Given an array, arr[] of rope lengths, connect all ropes into a single rope with
* the minimum total cost. The cost to connect two ropes is the sum of their lengths.

Examples:

Input: arr[] = [4, 3, 2, 6]
Output: 29
Explanation:
* First connect 2 and 3 to get [4, 5, 6] with a cost of 5,
* then connect 4 and 5 to get [9, 6] with a cost of 9, and
* finally connect 9 and 6 to get one rope with a cost of 15, giving a total minimum cost of 29.
* Any other order, such as connecting 4 and 6 first, results in a higher total cost of 38.
*
Input: arr[] = [4, 2, 7, 6, 9]
Output: 62
Explanation: First, connect ropes 4 and 2, which makes the array [6, 7, 6, 9].
* Cost of this operation 4 + 2 = 6. Next, add ropes 6 and 6, which results in [12, 7, 9].
* Cost of this operation 6 + 6 = 12. Then, add 7 and 9, which makes the array [12,16]. Cost of this operation 7 + 9 = 16.
* And finally, add these two which gives [28]. Hence, the total cost is 6 + 12 + 16 + 28 = 62.
*
* Input: arr[] = [10]
* Output: 0
* Explanation: Since there is only one rope, no connections are needed, so the cost is 0.
* */
public class a5_MinCostOfRopes {
  public static void main(String[] args) {
    int[] arr = {4, 2, 7, 6, 9};
    System.out.println("Minmum cost of ropes: " + minCost(arr));
  }

  private static int minCost(int[] arr) {
    if (arr.length <= 1) return 0; // No cost if only one or zero ropes

    // Min-heap to always get the two smallest ropes
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : arr) pq.offer(num);

    int totalCost = 0;

    // Keep combining two smallest ropes until one rope remains
    while (pq.size() > 1) {
      int first = pq.poll();
      int second = pq.poll();
      int cost = first + second;
      totalCost += cost;
      pq.offer(cost); // push combined rope back into heap
    }

    return totalCost;
  }
}
