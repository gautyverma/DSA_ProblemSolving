package gfg.a10_LinkedList.course;

public class OPS_LL {

  public Node initializeSortedLL() {
    Node head = null;
    head = insertSort(head, 10);
    head = insertSort(head, 30);
    head = insertSort(head, 40);
    head = insertSort(head, 20);
    head = insertSort(head, 60);
    head = insertSort(head, 50);
    head = insertSort(head, 90);
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
}
