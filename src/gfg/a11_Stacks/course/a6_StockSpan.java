package gfg.a11_Stacks.course;

import java.util.ArrayDeque;

public class a6_StockSpan {
  public static void main(String[] args) {
    int[] arr = {30, 20, 25, 28, 27, 29};
    printSpanNaive(arr);
    System.out.println();
    printSpanEff(arr);
  }

  private static void printSpanEff(int[] arr) {
    StackArray stack = new StackArray();
    stack.push(0);
    System.out.print(1 + " ");
    for (int i = 1; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.top] <= arr[i]) stack.pop();
      int span = stack.isEmpty() ? i + 1 : i - stack.top;
      System.out.print(span + " ");
      stack.push(i);
    }
  }

  private static void printSpanNaive(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int span = 1;
      for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) span++;
      System.out.print(span + " ");
    }
  }
}
