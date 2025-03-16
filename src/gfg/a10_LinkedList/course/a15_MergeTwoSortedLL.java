package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

public class a15_MergeTwoSortedLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head1 = ll.initializeSortedLL();
    Node head2 = ll.initializeSortedLL();
    ll.printLL(mergeSortedLL(head1, head2));
  }

  private static Node mergeSortedLL(Node head1, Node head2) {
    if (head1 == null) return head2;
    if (head2 == null) return head1;
    Node head = null, tail = null;
    if (head1.data <= head2.data) {
      head = head1;
      tail = head1;
      head1 = head1.next;
    } else {
      head = head2;
      tail = head2;
      head2 = head2.next;
    }
    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        tail.next = head1;
        tail = head1;
        head1 = head1.next;
      } else {
        tail.next = head2;
        tail = head2;
        head2 = head2.next;
      }
    }
    if (head1 == null) tail.next = head2;
    else tail.next = head1;
    return head;
  }
}
