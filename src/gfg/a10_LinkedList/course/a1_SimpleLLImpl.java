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

//  --- Basic Impl - 2
    Node head = new Node(10);
    head.next = new Node(15);
    head.next.next = new Node(20);
    head.next.next.next = new Node(25);
    head.next.next.next.next = new Node(30);
    head.next.next.next.next.next = new Node(35);

    // Traversing using loops
    printLL(head);

    // Traversing using recursion
    System.out.println(" \nRecursion ");
    printLLRecursive(head);
  }

  private static void printLLRecursive(Node head) {
    if(head != null){
      System.out.print(head.data +" ");
      printLLRecursive(head.next);
    }
    return;
  }

  private static void printLL(Node head) {
    Node curr = head;
    while(curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
  }
}
