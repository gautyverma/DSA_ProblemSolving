package gfg.a10_LinkedList.common;

public class OPS_LL {

  public Node initializeCycleLL() {
    Node head = new Node(10);
    Node n1 = new Node(20);
    Node n2 = new Node(30);
    Node n3 = new Node(40);
    Node n4 = new Node(50);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n2;
    return head;
  }

  public Node initializeCircularLL() {
    Node head = new Node(10);
    Node n1 = new Node(20);
    Node n2 = new Node(30);
    Node n3 = new Node(40);
    Node n4 = new Node(50);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = head;
    return head;
  }

  public Node initializeSortedLL() {
    Node head = null;
    head = insertSort(head, 1);
    head = insertSort(head, 3);
    head = insertSort(head, 4);
    head = insertSort(head, 2);
    head = insertSort(head, 6);
    head = insertSort(head, 5);
    head = insertSort(head, 9);
    return head;
  }

  public Node initializeDuplicateSortedLL() {
    Node head = null;
    head = insertSort(head, 10);
    head = insertSort(head, 10);
    head = insertSort(head, 10);
    head = insertSort(head, 30);
    head = insertSort(head, 30);
    head = insertSort(head, 30);
    head = insertSort(head, 20);
    head = insertSort(head, 60);
    head = insertSort(head, 50);
    head = insertSort(head, 60);
    head = insertSort(head, 50);
    head = insertSort(head, 90);
    head = insertSort(head, -20);
    return head;
  }

  public void printLL(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }

  public Node insertSort(Node head, int value) {
    Node temp = new Node(value);
    if (head == null) return temp;
    if (head.data > value) {
      temp.next = head;
      return temp;
    }
    Node curr = head;
    while (curr.next != null && curr.next.data < value) {
      curr = curr.next;
    }
    temp.next = curr.next;
    curr.next = temp;
    return head;
  }

  public void printMiddleEff(Node head) {
    if (head == null) return;
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    System.out.println("Middle element of LL :" + slow.data);
  }

  public Node reverseLL(Node head) {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev; // prev is new head
  }

  public Node initializeLL() {
    Node head = null;
    head = insertAtStart(head, 6);
    head = insertAtStart(head, 10);
    head = insertAtStart(head, 3);
    head = insertAtStart(head, 1);
    head = insertAtStart(head, 9);
    head = insertAtStart(head, 7);
    return head;
  }

  private Node insertAtStart(Node head, int value) {
    Node temp = new Node(value);
    temp.next = head;
    return temp;
  }
}
