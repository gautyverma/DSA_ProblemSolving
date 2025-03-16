package gfg.a10_LinkedList.exercise;

/*
*
* Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0

Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7
Output: 7 -> 0

Explanation: Given numbers are 63 and 7. There sum is 70.

Constraints:
1 <= size of both linked lists <= 106
0 <= elements of both linked lists <= 9
* */

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

import java.math.BigInteger;

public class a4_AddNumberLL {
  public static void main(String[] args) {

    OPS_LL ll = new OPS_LL();
    // LL1
    Node head1 = new Node(5);
    head1 = ll.insertAtStart(head1, 4);
    System.out.println("LL1 - ");
    ll.printLL(head1);

    // LL2
    Node head2 = new Node(5);
    head2 = ll.insertAtStart(head2, 4);
    head2 = ll.insertAtStart(head2, 3);
    System.out.println("LL2 - ");
    ll.printLL(head2);

    ll.printLL(addTwoLists(head1, head2));

    //    Integer t1 = 851670924409;
    long t1 = 8516709244L;
  }

  private static Node addTwoLists(Node num1, Node num2) {
    Node curr = num1;
    long temp1 = 0, temp2 = 0;
    while (curr != null) {
      temp1 = temp1 * 10 + curr.data;
      curr = curr.next;
    }
    System.out.println("num 1 - " + temp1);

    curr = num2;
    while (curr != null) {
      temp2 = temp2 * 10 + curr.data;
      curr = curr.next;
    }
    System.out.println("num 2 - " + temp2);
    long temp3 = temp1 + temp2;
    System.out.println("sum - " + temp3);

    temp3 = 851670924409L + 747810590830L;

    Node head = null;
    while (temp3 != 0) {
      /*
      Node temp = new Node(temp3 % 10);
      temp.next = head;
      head = temp;
      */
      head = insertAtStart(head, (int) (temp3 % 10));
      temp3 = temp3 / 10;
    }
    return head;
  }

  public static Node insertAtStart(Node head, int value) {
    Node temp = new Node(value);
    temp.next = head;
    return temp;
  }
}
