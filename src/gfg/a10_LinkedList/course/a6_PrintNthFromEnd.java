package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

public class a6_PrintNthFromEnd {
  public static void main(String[] args) {
    // 1 - method use len of LL and len - n + 1 to get position of node

    // 2 - method - using two pointers to get the required node
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeSortedLL();
    ll.printLL(head);
    printNthFromEnd(head, 3);
  }

  private static void printNthFromEnd(Node head, int posFromEnd) {
    if (head == null) return;
    Node first = head;
    for (int i = 0; i < posFromEnd; i++) {
      if (first == null) return;
      first = first.next;
    }
    Node second = head;
    while (first != null) {
      second = second.next;
      first = first.next;
    }
    System.out.println(posFromEnd + "position node from end: " + second.data);
  }
}
