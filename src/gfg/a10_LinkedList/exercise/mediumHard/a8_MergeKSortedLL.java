package gfg.a10_LinkedList.exercise.mediumHard;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

import java.util.ArrayList;
import java.util.List;

public class a8_MergeKSortedLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head1 = ll.initializeSortedLL();
    Node head2 = ll.initializeSortedLL();
    Node head3 = ll.initializeSortedLL();

    List<Node> list = new ArrayList<>();
    list.add(head1);
    list.add(head2);
    list.add(head3);
    ll.printLL(mergeKSortedLL(list));
  }

  private static Node mergeKSortedLL(List<Node> list) {
    if (list.size() == 0) {
      return null;
    } else if (list.size() == 1) {
      return list.get(0);
    } else {
      Node l1 = list.get(0);
      for (int i = 1; i < list.size(); i++) {
        l1 = mergeTwoSortedLL(l1, list.get(i));
      }
      return l1;
    }
  }

  private static Node mergeTwoSortedLL(Node head1, Node head2) {
    if (head1 == null) return head2;
    if (head2 == null) return head1;
    Node head = null, tail = null;
    // identify head and tail pointer
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
