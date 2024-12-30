package gfg.a11_Stacks.course;

import java.util.Stack;

public class a7_PreviousGreaterElement {
  public static void main(String[] args) {
    int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
    printPreviousGreater(arr);
  }

  private static void printPreviousGreater(int[] arr) {
    Stack<Integer> s = new Stack<>();
    s.push(arr[0]);
    System.out.print("-1" + " ");
    for (int i = 1; i < arr.length; i++) {
      while (!s.isEmpty() && s.peek() < arr[i]) s.pop();
      if (s.isEmpty()) System.out.print("-1" + " ");
      else System.out.print(s.peek() + " ");
      s.push(arr[i]);
    }
  }
}
