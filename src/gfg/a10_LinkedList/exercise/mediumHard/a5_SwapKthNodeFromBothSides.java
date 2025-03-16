package gfg.a10_LinkedList.exercise.mediumHard;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

/*
* A singly linked list and an integer of k are given. You need to swap the kth node from the beginning and the kth node from the end of the linked list. Swap the nodes through the links. Do not change the content of the nodes.

Note: The driver code will output "true" if you successfully swap the nodes.

Examples:

Input: LinkedList: 1->2->3->4, k = 1
Output: true
Explanation: Here k = 1, hence after swapping the 1st node from the beginning and end the new list will be 4->2->3->1.
Input: LinkedList: 1->2->3->4->5, k = 7
Output: true
Explanation: k > n. Swapping is invalid. Return the head node as it is.

Expected Time Complexity: O(n)
Expected Auxillary Space: O(1)

Constraints:
1 <= number of nodes <= 103
1 <= node->data <= 106
1 <= k <= 103
* */

public class a5_SwapKthNodeFromBothSides {
  public static void main(String[] args) {
    OPS_LL ll = new OPS_LL();
    // LL1
    Node head = null;
    int[] arr = {1, 3, 5, 7, 9};
    for (int i : arr) {
      head = ll.insertAtStart(head, i);
    }
    head = ll.reverseLL(head);
    ll.printLL(head);

    //    ll.printLL(swapKthNode(head, 2));
    //    ll.printLL(swapKthNode(head, 1));
    ll.printLL(swapKthNode(head, 5));
  }

  private static Node swapKthNode(Node head, int k) {
    int n = getCount(head);

    // If k is greater than number of nodes, return the list as it is
    if (k > n) return head;

    // If kth node from start and end are the same, no need to swap
    if (2 * k - 1 == n) return head;

    // Find the kth node from the start
    Node firstPrev = null, first = head;
    for (int i = 1; i < k; i++) {
      firstPrev = first;
      first = first.next;
    }

    // Find the kth node from the end
    Node secondPrev = null, second = head;
    for (int i = 1; i < n - k + 1; i++) {
      secondPrev = second;
      second = second.next;
    }

    // Swap nodes by updating previous nodes' next pointers
    if (firstPrev != null) firstPrev.next = second;
    if (secondPrev != null) secondPrev.next = first;

    // Swap next pointers of the nodes
    Node temp = first.next;
    first.next = second.next;
    second.next = temp;

    // If swapping involves head node, update head
    if (k == 1) head = second;
    if (k == n) head = first;

    return head;
  }

  private static int getCount(Node head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

}
