package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

public class a10_ReverseKNode {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeSortedLL();
    ll.printLL(head);
    head = revserseKNodeRec(head, 3);
    ll.printLL(head);
    head = revserseKNodeIter(head, 3);
    ll.printLL(head);
  }

  private static Node revserseKNodeIter(Node head, int k) {
    Node curr = head, prevFirst = null;
    boolean isFirstPass = true;
    while (curr != null) {
      Node first = curr, prev = null;
      int count = 0;
      while (curr != null && count < k) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        count++;
      }
      if (isFirstPass) {
        head = prev;
        isFirstPass = false;
      } else {
        prevFirst.next = prev;
      }
      prevFirst = first;
    }
    return head;
  }

  private static Node revserseKNodeRec(Node head, int k) {
    Node curr = head, next = null, prev = null;
    int count = 0;
    while (curr != null && count < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }
    if (next != null) {
      Node restHead = revserseKNodeRec(next, k);
      head.next = restHead;
    }
    return prev;
  }
}
