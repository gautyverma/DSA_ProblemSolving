package gfg.a10_LinkedList.course;

public class a14_PairwiseSwapLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeSortedLL();
    ll.printLL(head);
    head = pairSwap(head);
    ll.printLL(head);
  }

  private static Node pairSwap(Node head) {
    if (head == null || head.next == null) return head;
    Node curr = head.next.next; // 3rd Node form start
    // Swap head and head.next
    Node prev = head;
    head = head.next;
    head.next = prev;

    while (curr != null && curr.next != null) {
      prev.next = curr.next;
      prev = curr;
      Node next = curr.next.next;
      curr.next.next = curr;
      curr = next;
    }
    prev.next = curr;
    return head;
  }
}
