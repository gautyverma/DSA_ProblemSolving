package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

public class a7_ReverseLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeSortedLL();
    ll.printLL(head);
    head = ll.reverseLL(head);
    ll.printLL(head);
  }

  private static Node reverseLL(Node head) {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev; // prev is new head
  }
}
