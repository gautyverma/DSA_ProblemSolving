package gfg.a10_LinkedList.exercise;

import gfg.a10_LinkedList.common.NodeDoubleLL;
import gfg.a10_LinkedList.common.OPS_DLL;

public class a3_DLLInsertAtPosition {
  public static void main(String[] args) {
    OPS_DLL dll = new OPS_DLL();
    NodeDoubleLL head = dll.initializeRandomDLL();
    dll.printDLL(head);
    dll.printDLL(addNodePos(head, 3, 19));
    dll.printDLL(addNodePos(head, 0, 19));
  }

  private static NodeDoubleLL addNodePos(NodeDoubleLL head, int pos, int value) {
    NodeDoubleLL temp = new NodeDoubleLL(value);
    if (pos == 0) {
      // insert at start
      head.prev = temp;
      temp.next = head;
      return temp;
    }
    NodeDoubleLL curr = head;
    for (int i = 0; i < pos; i++) {
      curr = curr.next;
    }
    temp.next = curr.next;
    curr.next = temp;
    temp.prev = curr;
    return head;
  }
}
