package gfg.a10_LinkedList.common;

public class OPS_DLL {
  public NodeDoubleLL initializeRandomDLL() {
    NodeDoubleLL head = null;
    head = insertAtStart(head, 5);
    head = insertAtStart(head, 3);
    head = insertAtStart(head, 78);
    head = insertAtStart(head, 9);
    head = insertAtStart(head, 15);
    head = insertAtStart(head, 54);
    head = insertAtStart(head, 17);
    head = insertAtStart(head, 4);
    head = insertAtStart(head, 39);

    return head;
  }

  private NodeDoubleLL insertAtStart(NodeDoubleLL head, int value) {
    NodeDoubleLL temp = new NodeDoubleLL(value);
    temp.next = head;
    if (head != null) head.prev = temp;
    return temp;
  }

  public void printDLL(NodeDoubleLL head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }

    public NodeDoubleLL initializeSortedDLL() {
      NodeDoubleLL head = null;
      head = insertAtStart(head, 51);
      head = insertAtStart(head, 30);
      head = insertAtStart(head, 28);
      head = insertAtStart(head, 19);
      head = insertAtStart(head, 15);
      head = insertAtStart(head, 10);
      head = insertAtStart(head, 5);
      head = insertAtStart(head, 4);
      head = insertAtStart(head, 3);
      return head;
    }
}
