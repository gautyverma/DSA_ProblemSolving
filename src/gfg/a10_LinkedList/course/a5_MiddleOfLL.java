package gfg.a10_LinkedList.course;

public class a5_MiddleOfLL {
  public static void main(String[] args) {

    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeSortedLL();

    ll.printLL(head);
    ll.printMiddleEff(head);
  }
}
