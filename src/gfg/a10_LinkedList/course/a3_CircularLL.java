package gfg.a10_LinkedList.course;

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
    }else{
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
