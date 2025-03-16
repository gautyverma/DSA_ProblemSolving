package gfg.a10_LinkedList.exercise;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

public class a1_CountNodes {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    Node head = ll.initializeLL();
    ll.printLL(head);
    // problem 1 - Count number of nodes in LL
    System.out.println(getCount(head));
  }

  private static int getCount(Node head) {
    if (head == null) return 0;

    int res = 0;
    while (head != null) {
      res++;
      head = head.next;
    }
    return res;
  }
}

