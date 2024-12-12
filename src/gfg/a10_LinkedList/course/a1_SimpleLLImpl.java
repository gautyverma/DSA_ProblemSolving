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

    NodeSingleLL head = null;
    head = insertAtEnd(head, 2);
    head = insertAtStart(head, 10);
    head = insertAtStart(head, 7);
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

    // ops - Searching LL
    System.out.println("<-Search value in LL and return its position->");
    System.out.println("--> Iterative");
    System.out.println(searchLLIter(head, 10));
    System.out.println(searchLLIter(head, 100));
    System.out.println("--> Recursive");
    System.out.println(searchLLRec(head, 10));
    System.out.println(searchLLRec(head, 100));
    System.out.println("-------------");
  }

  private static int searchLLRec(NodeSingleLL head, int value) {
    if(head == null)
      return -1;
    if(head.data == value){
      return 1;
    }
    else{
      int res = searchLLRec(head.next,value);
      if(res == -1)
        return -1;
      else
        return res + 1;
    }
  }

  private static int searchLLIter(NodeSingleLL head, int value) {
    int posCount = 1;
    while (head != null) {
      if (head.data == value) {
        return posCount;
      }
      head = head.next;
      posCount++;
    }
    return -1;
  }

  private static NodeSingleLL deleteAtEnd(NodeSingleLL head) {
    if (head == null || head.next == null) return null;
    NodeSingleLL prev = head;
    NodeSingleLL curr = head.next;
    while (curr.next != null) {
      prev = curr;
      curr = curr.next;
    }
    prev.next = null;
    return head;
  }

  private static NodeSingleLL deleteAtStart(NodeSingleLL head) {
    if (head == null || head.next == null) return null;
    else return head.next;
  }

  private static NodeSingleLL insertAtMiddle(NodeSingleLL head, int pos, int value) {
    NodeSingleLL temp = new NodeSingleLL(value);
    if (pos == 1) {
      temp.next = head;
      return temp;
    }
    NodeSingleLL curr = head;
    for (int i = 1; i <= pos - 2 && curr != null; i++) curr = curr.next;
    if (curr == null) return head;
    temp.next = curr.next;
    curr.next = temp;
    return head;
  }

  private static NodeSingleLL insertAtEnd(NodeSingleLL head, int value) {
    NodeSingleLL temp = new NodeSingleLL(value);
    if (head == null) {
      return temp;
    }
    NodeSingleLL curr = head;
    while (curr.next != null) curr = curr.next;
    curr.next = temp;
    return head;
  }

  private static NodeSingleLL insertAtStart(NodeSingleLL head, int value) {
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

    NodeSingleLL temp = new NodeSingleLL(value);
    temp.next = head;
    return temp;
  }

  private static void printLLRecursive(NodeSingleLL head) {
    if (head != null) {
      System.out.print(head.data + " ");
      printLLRecursive(head.next);
    }
    return;
  }

  private static void printLL(NodeSingleLL head) {
    NodeSingleLL curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
  }
}
