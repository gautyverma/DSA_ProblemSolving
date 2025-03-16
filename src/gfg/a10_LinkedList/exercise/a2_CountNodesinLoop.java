package gfg.a10_LinkedList.exercise;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

import java.util.HashSet;

public class a2_CountNodesinLoop {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeCycleLL();
    System.out.println("using hashSet - " + countNodesinLoop(head));
    System.out.println("using Floyd - " + countNodesinLoopFloyd(head));
  }

  // approach 1 - using hashset
  private static int countNodesinLoop(Node head) {
    HashSet set = new HashSet();
    Node curr = head;
    int res = 0;
    while (curr != null) {
      if (set.contains(curr)) {
        // add logic
        Node startOfLoop = curr;
        do {
          res++;
          curr = curr.next;
        } while (startOfLoop != curr);
        return res;
      }
      set.add(curr);
      curr = curr.next;
    }
    return res;
  }

  // approach 2 - using floyd cycle detection
  private static int countNodesinLoopFloyd(Node head) {
    Node slow = head, fast = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      // If slow and fast meet at some
      // point then there is a loop
      if (slow == fast) {
        return countNodes(slow);
      }
    }
    return 0;
  }

  private static int countNodes(Node node) {
    int count = 1; // if there is self pointing
    Node curr = node;
    while (curr.next != node) {
      count++;
      curr = curr.next;
    }
    return count;
  }
}
