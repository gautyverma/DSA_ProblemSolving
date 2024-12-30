package gfg.a11_Stacks.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class a8_NextGreaterElement {
  public static void main(String[] args) {
    int[] arr = {5, 15, 10, 8, 6, 12, 9, 18};
    printNextGreater(arr);
  }

  private static void printNextGreater(int[] arr) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    s.push(arr[arr.length - 1]);
    list.add(-1);
    for (int i = arr.length - 2; i >= 0; i--) {
      while (!s.isEmpty() && s.peek() <= arr[i]) s.pop();
      list.add(s.isEmpty() ? -1 : s.peek());
      s.push(arr[i]);
    } // takes output in reverse order
    Collections.reverse(list);
    System.out.println(list);
  }
}
