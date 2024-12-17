package gfg.a10_LinkedList.course;

public class a4_SortedInsertLL {
  public static void main(String[] args) {

    Node head = null;
    head = insertSort(head, 10);
    printLL(head);
    System.out.println("------------------");
    head = insertSort(head, 5);
    printLL(head);
    System.out.println("------------------");
    head = insertSort(head, 130);
    printLL(head);
    System.out.println("------------------");
    head = insertSort(head, 20);
    printLL(head);
    System.out.println("------------------");
    head = insertSort(head, 30);
    printLL(head);
    System.out.println("------------------");
    head = insertSort(head, 10);
  }

  private static void printLL(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();
  }

  private static Node insertSort(Node head, int value) {
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
}
