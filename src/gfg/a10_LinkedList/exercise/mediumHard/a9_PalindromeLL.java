package gfg.a10_LinkedList.exercise.mediumHard;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

import java.util.ArrayDeque;
import java.util.Deque;

public class a9_PalindromeLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeLL();
    System.out.println(isPalindrome(head));
  }

  private static boolean isPalindrome(Node head) {
    Deque<Integer> s = new ArrayDeque<>();
    for (Node curr = head; curr != null; curr = curr.next) {
      s.push(curr.data);
    }
    for (Node curr = head; curr != null; curr = curr.next) {
      if (s.pop() != curr.data) {
        return false;
      }
    }
    return true;
  }
}
