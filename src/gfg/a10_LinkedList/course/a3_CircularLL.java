package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.Node;

public class a3_CircularLL {
  public static void main(String[] args) {
    Node head = null;
    head = insertAtStartNaive(head, 30);
    head = insertAtStartEff(head, 15);
    head = insertAtStartNaive(head, 20);
    head = insertAtStartNaive(head, 10);

    // Traversing
    System.out.println("Traversing circular LL");
    printCLL(head);
    System.out.println("-------------");

    // OPS - Insert at start
    System.out.println("Insert at start of circular LL");
    head = insertAtStartNaive(head, 5);
    head = insertAtStartEff(head, 7);
    printCLL(head);
    System.out.println("-------------");

    // OPS - Insert at End
    System.out.println("Insert at End of circular LL");
    head = insertAtEndNaive(head, 35);
    head = insertAtEndEff(head, 45);
    printCLL(head);
    System.out.println("-------------");

    // OPS - Deletion at start
    System.out.println("Delete at Start of circular LL");
    head = deleteAtStartNaive(head);
    head = deleteAtStartEff(head);
    printCLL(head);
    System.out.println("-------------");

    // OPS - Deletion at Kth position k<= number of nodes
    System.out.println("Delete at Kth pos of circular LL");
    head = deleteAtPos(head, 3);
    printCLL(head);
    head = deleteAtPos(head, 2);
    printCLL(head);
    System.out.println("-------------");
  }

  private static Node deleteAtPos(Node head, int pos) {
    if (pos == 1) return deleteAtStartEff(head);
    Node curr = head;
    //    pos--; // To take curr as prev node of position node
    while (pos != 2) {
      pos--;
      curr = curr.next;
    }
    /* -- other impl of above loop

    for(int i = 0 ;i<pos-2;i++){
          curr = curr.next;
        }
        */
    curr.next = curr.next.next;
    return head;
  }

  private static Node deleteAtStartEff(Node head) {
    if (head == null || head.next == head) return null;

    head.data = head.next.data;
    head.next = head.next.next;
    return head;
  }

  private static Node deleteAtStartNaive(Node head) {
    if (head == null || head.next == head) return null;
    Node curr = head;
    while (curr.next != head) curr = curr.next;
    curr.next = head.next;
    return curr.next;
  }

  private static Node insertAtEndEff(Node head, int value) {
    Node temp = new Node(value);
    if (head == null) {
      temp.next = temp;
      return temp;
    } else {
      temp.next = head.next;
      head.next = temp;
      int swapData = head.data;
      head.data = temp.data;
      temp.data = swapData;
      return temp;
    }
  }

  private static Node insertAtEndNaive(Node head, int value) {
    Node temp = new Node(value);
    if (head == null) {
      temp.next = temp;
      return temp;
    } else {
      Node curr = head;
      while (curr.next != head) curr = curr.next;
      curr.next = temp;
      temp.next = head;
    }
    return head;
  }

  private static Node insertAtStartEff(Node head, int value) {
    Node temp = new Node(value);
    if (head == null) {
      temp.next = temp;
      return temp;
    } else {
      temp.next = head.next;
      head.next = temp;
      int swapData = head.data;
      head.data = temp.data;
      temp.data = swapData;
      return head;
    }
  }

  private static Node insertAtStartNaive(Node head, int value) {
    Node temp = new Node(value);
    /*

        if (head == null) return new Node(value);

    // Find tail node
        Node tail = head.next;
        if (tail == null) {
          tail = head;
          temp.next = head;
          tail.next = temp;
          return temp;
        }
        while (tail.next != head) {
          tail = tail.next;
        }
        temp.next = head;
        tail.next = temp;
        return temp;
        */

    if (head == null) temp.next = temp;
    else {
      Node curr = head;
      while (curr.next != head) curr = curr.next;
      curr.next = temp;
      temp.next = head;
    }
    return temp;
  }

  private static void printCLL(Node head) {
    if (head == null) return;
    System.out.print(head.data + " ");
    for (Node curr = head.next; curr != null && curr != head; curr = curr.next) {
      System.out.print(curr.data + " ");
    }
    System.out.println();
  }
}
