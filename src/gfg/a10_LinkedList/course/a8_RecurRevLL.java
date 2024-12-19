package gfg.a10_LinkedList.course;

public class a8_RecurRevLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeSortedLL();
    ll.printLL(head);
    head = recRevLL1(head);
    ll.printLL(head);
    head = recRevLL2(head, null);
    ll.printLL(head);
  }

  private static Node recRevLL2(Node curr, Node prev) {
    if (curr == null) return prev;
    Node next = curr.next;
    curr.next = prev;
    return recRevLL2(next, curr);
  }

  private static Node recRevLL1(Node head) {
    // Base case
    if (head == null || head.next == null) return head;
    // ------------
    Node restHead = recRevLL1(head.next);
    Node restTail = head.next;
    restTail.next = head;
    head.next = null;
    return restHead;
  }
}
