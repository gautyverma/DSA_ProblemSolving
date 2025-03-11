package gfg.a13_Deque.course;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class a2_MaxInSubArrOfSizeK {
  public static void main(String[] args) {
    int[] arr = {10, 8, 5, 12, 15, 7, 6};
    int k = 3;
    System.out.println("Naive solution - " + getMaxSubArrNaiveSol(arr, k));
    System.out.println("Efficient solution - " + getMaxSubArrEffSol(arr, k));
  }

  private static List<Integer> getMaxSubArrEffSol(int[] arr, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<>();
    // 1st - for loop 0 to k to get 1st max in sub array of size k
    for (int i = 0; i < k; i++) {
      while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) dq.removeLast();
      dq.addLast(i);
    }

    // 2nd - for loop from k to n
    for (int i = k; i < arr.length; i++) {
      res.add(arr[dq.peek()]);
      // 1st while - remove element form subarray window
      while (!dq.isEmpty() && dq.peek() <= i - k) dq.removeFirst();
      // 2nd while - remove element from dq if larger element comes
      while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) dq.removeLast();
      dq.addLast(i);
    }
    res.add(arr[dq.peek()]);
    return res;
  }

  private static List<Integer> getMaxSubArrNaiveSol(int[] arr, int k) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i <= arr.length - k; i++) {
      int max = arr[i];
      for (int j = i + 1; j < i + k; j++) {
        max = arr[j] > max ? arr[j] : max;
      }
      res.add(max);
    }
    return res;
  }
}
