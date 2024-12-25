package gfg.a10_LinkedList.course;

import java.util.HashSet;

public class a11_DetectLoopLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    System.out.println(isLoopInLL(ll.initializeCycleLL()));
    System.out.println(isLoopInLL(ll.initializeCircularLL()));

    System.out.println(isLoopHashInLL(ll.initializeCycleLL()));
    System.out.println(isLoopHashInLL(ll.initializeCircularLL()));
  }

  /*
   * Traverse LL, if node visited add to hashSet and if again visited check if present already
   * */
  private static boolean isLoopHashInLL(Node head) {
    HashSet<Node> hashSet = new HashSet<Node>();
    for (Node curr = head; curr != null; curr = curr.next) {
      if (hashSet.contains(curr)) return true;
      hashSet.add(curr);
    }
    return false;
  }

  /*  Method - Modification of LL is there,
   *  traverse and change next of curr to temp node and later check loop back node points to temp or not
   * */
  private static boolean isLoopInLL(Node head) {
    Node temp = new Node(0);
    Node curr = head;
    while (curr != null) {
      if (curr.next == null) return false;
      if (curr.next == temp) return true;
      Node next = curr.next;
      curr.next = temp;
      curr = next;
    }
    return false;
  }
}