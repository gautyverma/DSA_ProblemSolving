package gfg.a10_LinkedList.course;

public class a13_SegregateEvenOdd {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeSortedLL();
    ll.printLL(head);
    head = segregateEvenOdd(head);
    ll.printLL(head);
  }

  private static Node segregateEvenOdd(Node head) {
    Node curr = head, oddHead = null, oddTail = null, evenHead = null, evenTail = null;
    while (curr != null) {
      if (curr.data % 2 == 0) {
        if (evenHead == null) {
          evenHead = curr;
          evenTail = curr;
        } else {
          evenTail.next = curr;
          evenTail = evenTail.next;
        }
      } else {
        if (oddHead == null) {
          oddHead = curr;
          oddTail = curr;
        } else {
          oddTail.next = curr;
          oddTail = oddTail.next;
        }
      }
      curr = curr.next;
    }

    if (oddHead == null || evenHead == null) return head;

    evenTail.next = oddHead;
    oddTail.next = null;
    return evenHead;
  }
}
