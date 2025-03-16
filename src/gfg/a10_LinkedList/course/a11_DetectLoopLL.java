package gfg.a10_LinkedList.course;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

import java.util.HashSet;

public class a11_DetectLoopLL {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();

    System.out.println(" ---- pointing dummy node ---- ");
    System.out.println(isLoopInLL(ll.initializeCycleLL()));
    System.out.println(isLoopInLL(ll.initializeCircularLL()));

    System.out.println(" ---- Using hashSet ---- ");
    System.out.println(isLoopHashInLL(ll.initializeCycleLL()));
    System.out.println(isLoopHashInLL(ll.initializeCircularLL()));

    System.out.println(" ---- Floyd cycle detection ---- ");
    System.out.println(isLoopFloydInLL(ll.initializeCycleLL()));
    System.out.println(isLoopFloydInLL(ll.initializeCircularLL()));
  }

  /*
   * Detect loop using floyd cycle detection
   * 1. Initialize slowPointer and fastPointer from head.
   * 2. Move slowPointer by 1 and fastPointer by 2. If they meet loop is there.
   * */
  private static boolean isLoopFloydInLL(Node head) {
    Node slowP = head,fastP = head;
    while(fastP != null && fastP.next !=null){
      slowP = slowP.next;
      fastP = fastP.next.next;

      if(slowP == fastP)
        return true;
    }
    return false;
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
