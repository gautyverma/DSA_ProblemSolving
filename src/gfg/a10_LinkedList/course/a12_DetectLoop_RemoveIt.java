package gfg.a10_LinkedList.course;

public class a12_DetectLoop_RemoveIt {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();

    Node head = ll.initializeCycleLL();
//    ll.printLL(head); -> Run for life
    detectRemoveLoop(head);
    ll.printLL(head);
  }

  private static void detectRemoveLoop(Node head) {
    // Detect loop using floyd algo
    Node slowP = head, fastP = head;
    while (fastP != null && fastP.next != null) {
      slowP = slowP.next;
      fastP = fastP.next.next;
      if (slowP == fastP) break;
    }
    if (slowP != fastP) return;
    slowP = head;
    while (slowP.next != fastP.next) {
      slowP = slowP.next;
      fastP = fastP.next;
    }
    fastP.next = null;
  }
}
