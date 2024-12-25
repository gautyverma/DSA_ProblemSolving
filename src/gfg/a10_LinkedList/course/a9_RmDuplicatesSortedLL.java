package gfg.a10_LinkedList.course;

public class a9_RmDuplicatesSortedLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeDuplicateSortedLL();
    ll.printLL(head);
    rmDupFrmSortedLL(head);
    ll.printLL(head);
  }

  private static void rmDupFrmSortedLL(Node head) {

    Node curr = head;
    while (curr != null && curr.next != null) {
      if (curr.data == curr.next.data) curr.next = curr.next.next;
      else curr = curr.next;
    }
  }
}
