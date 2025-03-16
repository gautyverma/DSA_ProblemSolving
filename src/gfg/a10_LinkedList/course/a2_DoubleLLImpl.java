package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.NodeDoubleLL;

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
    System.out.println("----------------");

    // ops - Insert at beginning of DLL
    System.out.println("<-insertion at beginning->");
    head = insertAtStart(head, 5);
    printDLL(head);
    System.out.println("----------------");

    // ops - Insert at ending of DLL
    System.out.println("<-insertion at ending->");
    head = insertAtEnd(head, 45);
    printDLL(head);
    System.out.println("----------------");

    // ops - Delete at beginning of DLL
    System.out.println("<-Deletion at beginning->");
    head = deleteAtStart(head);
    printDLL(head);
    System.out.println("----------------");

    // ops - Delete at ending of DLL
    System.out.println("<-Deletion at ending->");
    head = deleteAtEnd(head);
    printDLL(head);
    System.out.println("----------------");
  }

  private static NodeDoubleLL deleteAtEnd(NodeDoubleLL head) {
    if(head == null || head.next == null)
      return null;
    NodeDoubleLL curr = head;
    while(curr.next.next!=null){
      curr = curr.next;
    }
    curr.next = null;
    return head;
  }

  private static NodeDoubleLL deleteAtStart(NodeDoubleLL head) {
    if(head == null || head.next == null)
      return null;
    head = head.next;
    head.prev = null;
    return head;
  }

  private static NodeDoubleLL insertAtEnd(NodeDoubleLL head, int value) {
    NodeDoubleLL temp = new NodeDoubleLL(value);
    if (head == null) return temp;
    NodeDoubleLL curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = temp;
    temp.prev = curr;
    return head;
  }

  private static NodeDoubleLL insertAtStart(NodeDoubleLL head, int value) {

    NodeDoubleLL temp = new NodeDoubleLL(value);
    /*

        if (head == null) return temp;
        else{
          head.prev = temp;
           temp.next = head;
          head = temp;
        }
        return head;
    */
    temp.next = head;
    if (head != null) head.prev = temp;
    return temp;
  }

  private static void printDLL(NodeDoubleLL head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}
