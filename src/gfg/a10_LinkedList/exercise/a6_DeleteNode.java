package gfg.a10_LinkedList.exercise;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

/*
* Delete without head pointer
You are given a node del_node of a Singly Linked List where you have to delete a value of the given node from the linked list but you are not given the head of the list.

By deleting the node value, we do not mean removing it from memory. We mean:

The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before & after the del_node node should be in the same order.
Note:

Multiple nodes can have the same values as the del_node, but you must only remove the node whose pointer del_node is given to you.
It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.
Examples:

Input: Linked List = 1 -> 2, del_node = 1
Output: 2
Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.

Input: Linked List = 10 -> 20 -> 4 -> 30, del_node = 20
Output: 10->4->30
Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.

Constraints:
2 <= number of nodes <= 106
1 <= node->data <= 106
* */
public class a6_DeleteNode {
  public static void main(String[] args) {
    Node head = new Node(1);
    Node n1 = new Node(2);
    Node n2 = new Node(3);
    Node n3 = new Node(2);
    Node n4 = new Node(1);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    OPS_LL ll = new OPS_LL();
    ll.printLL(head);
    deleteNode(n3);
    ll.printLL(head);
  }

  private static void deleteNode(Node node) {
    // check node is last node or null
    if (node == null || node.next == null) return;
    node.data = node.next.data;
    node.next = node.next.next;
  }
}
