package gfg.a11_Stacks.course;

import java.util.*;

public class a6_StockSpan {
  public static void main(String[] args) {
    Integer[] arr = {30, 20, 25, 28, 27, 29};
    printSpanNaive(arr);
    System.out.println("\n-----------");
    printSpanEff(arr);
    System.out.println("\n-----------");
    ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arr));
    System.out.println(calculateSpan(arrList));
  }

  static ArrayList<Integer> calculateSpan(ArrayList<Integer> arr) {

    int n = arr.size();
    ArrayList<Integer> span = new ArrayList<>(Collections.nCopies(n, 0));
    Stack<Integer> stk = new Stack<>();

    // Process each day's price
    for (int i = 0; i < n; i++) {

      // Remove elements from the stack while the
      // current price is greater than or equal to
      // stack's top price
      while (!stk.isEmpty() && arr.get(stk.peek()) <= arr.get(i)) {
        stk.pop();
      }

      // If stack is empty, all elements to the
      // left are smaller
      // Else, top of the stack is the last greater
      // element's index
      if (stk.isEmpty()) {
        span.set(i, (i + 1));
      } else {
        span.set(i, (i - stk.peek()));
      }

      // Push the current index to the stack
      stk.push(i);
    }

    return span;
  }

  private static void printSpanEff(Integer[] arr) {
    StackArray stack = new StackArray();
    stack.push(0);
    System.out.print(1 + " ");
    for (int i = 1; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
      int span = stack.isEmpty() ? i + 1 : i - stack.peek();
      System.out.print(span + " ");
      stack.push(i);
    }
  }

  private static void printSpanNaive(Integer[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int span = 1;
      for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) span++;
      System.out.print(span + " ");
    }
  }
}
