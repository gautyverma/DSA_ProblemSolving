package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.NodeDoubleLL;

public class a3_RevDLL {
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

    // ops - Reverse
    System.out.println("<-Reverse->");
    head = reverseDLL(head);
    printDLL(head);
    System.out.println("----------------");
  }

  private static NodeDoubleLL reverseDLL(NodeDoubleLL head) {
    /*
    if (head == null) return null;
    NodeDoubleLL curr = head;
    while (curr.next != null) curr = curr.next;

    head = curr;

    while (head.prev != null) {
      System.out.print(head.data + " ");
      head = head.prev;
    }
    System.out.println(head.data);
    return null;
    */
    if(head == null || head.next == null)
      return head;
    NodeDoubleLL prev = null;
    NodeDoubleLL curr = head;
    while(curr != null){
      prev = curr.prev;
      curr.prev = curr.next;
      curr.next = prev;
      curr = curr.prev;
    }
    return prev.prev;
  }

  private static void printDLL(NodeDoubleLL head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}
