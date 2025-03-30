package gfg.a11_Stacks.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class a8_NextGreaterElement {
  public static void main(String[] args) {
    int[] arr = {5, 15, 10, 8, 6, 12, 9, 18};
    printNextGreater(arr);
  }

  /**
   * This method finds the Next Greater Element (NGE) for each element in the given array. - It
   * processes elements from right to left using a stack. - For each element, it pops stack elements
   * that are smaller or equal. - If the stack is empty, it means there is no greater element to the
   * right, so -1 is added. - Otherwise, the top of the stack is the next greater element. - The
   * element is then pushed onto the stack for future comparisons. - Since elements are processed
   * from right to left, the result is stored in reverse order and corrected using
   * Collections.reverse().
   */
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
