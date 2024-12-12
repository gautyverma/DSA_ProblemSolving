package gfg.a10_LinkedList.course;

public class a1_SimpleLLImpl {
  public static void main(String[] args) {

    /*
        // --- Basic Impl - 1
        Node head = new Node(10);
        Node t1 = new Node(15);
        Node t2 = new Node(20);
        head.next = t1;
        t1.next = t2;
    */

    /*
        //  --- Basic Impl - 2
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(20);
        head.next.next.next = new Node(25);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(35);
    */

    Node head = null;
    head = insertAtEnd(head, 2);
    head = insertAtStart(head, 10);
    //    head = insertAtStart(head, 7);
    head = insertAtStart(head, 4);

    // Traversing using recursion
    System.out.println("Recursion");
    printLLRecursive(head);
    System.out.println("\n-------------");

    // ops - Insert at beginning of LL
    System.out.println("<-insertion at beginning->");
    head = insertAtStart(head, 1);
    printLL(head);
    System.out.println("\n-------------");

    // ops - Insert at end of LL
    System.out.println("<-insertion at end->");
    head = insertAtEnd(head, 13);
    printLL(head);
    System.out.println("\n-------------");

    // ops - Insert at middle of LL after some passes
    System.out.println("<-insertion at middle->");
    head = insertAtMiddle(head, 3, 7);
    printLL(head);
    System.out.println("\n-------------");

    // ops - Deletion at start
    System.out.println("<-deletion at start->");
    head = deleteAtStart(head);
    printLL(head);
    System.out.println("\n-------------");

    // ops - Deletion at end
    System.out.println("<-deletion at End->");
    head = deleteAtEnd(head);
    printLL(head);
    System.out.println("\n-------------");
  }

  private static Node deleteAtEnd(Node head) {
    if (head == null || head.next == null) return null;
    Node prev = head;
    Node curr = head.next;
    while(curr.next != null){
      prev = curr;
      curr = curr.next;
    }
    prev.next = null;
    return head;
  }

  private static Node deleteAtStart(Node head) {
    if (head == null || head.next == null) return null;
    else return head.next;
  }

  private static Node insertAtMiddle(Node head, int pos, int value) {
    Node temp = new Node(value);
    if (pos == 1) {
      temp.next = head;
      return temp;
    }
    Node curr = head;
    for (int i = 1; i <= pos - 2 && curr != null; i++) curr = curr.next;
    if (curr == null) return head;
    temp.next = curr.next;
    curr.next = temp;
    return head;
  }

  private static Node insertAtEnd(Node head, int value) {
    Node temp = new Node(value);
    if (head == null) {
      return temp;
    }
    Node curr = head;
    while (curr.next != null) curr = curr.next;
    curr.next = temp;
    return head;
  }

  private static Node insertAtStart(Node head, int value) {
    /*
    if (head == null) {
      head = new Node(value);
    } else {
      Node curr = head;
      head = new Node(value);
      head.next = curr;
    }
    return head;
    */

    Node temp = new Node(value);
    temp.next = head;
    return temp;
  }

  private static void printLLRecursive(Node head) {
    if (head != null) {
      System.out.print(head.data + " ");
      printLLRecursive(head.next);
    }
    return;
  }

  private static void printLL(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
  }
}
