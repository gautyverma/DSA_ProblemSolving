package gfg.a10_LinkedList.course;

public class a2_DoubleLLImpl {
  public static void main(String[] args) {

    NodeDoubleLL head = new NodeDoubleLL(10);
    NodeDoubleLL node1 = new NodeDoubleLL(20);
    NodeDoubleLL node2 = new NodeDoubleLL(30);
    NodeDoubleLL node3 = new NodeDoubleLL(40);

    head.next = node1;

    node1.prev = head;
    node1.next = node2;

    node2.prev = node1;
    node2.next = node3;

    node3.prev = node2;

    printDLL(head);
  }

  private static void printDLL(NodeDoubleLL head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}
