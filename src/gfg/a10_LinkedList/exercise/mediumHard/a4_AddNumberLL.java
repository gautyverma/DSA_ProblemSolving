package gfg.a10_LinkedList.exercise.mediumHard;

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

public class a4_AddNumberLL {
  public static void main(String[] args) {

    OPS_LL ll = new OPS_LL();
    // LL1
    Node head1 = null;
    int[] arr1 = {8, 5, 1, 6, 7, 0, 9, 2, 4, 4, 0, 9};
    for (int i : arr1) {
      head1 = ll.insertAtStart(head1, i);
    }
    System.out.println("LL1 - ");
    ll.printLL(head1);

    // LL2
    Node head2 = null;
    int[] arr2 = {7, 4, 7, 8, 1, 0, 5, 9, 0, 8, 3, 0};
    for (int i : arr2) {
      head2 = ll.insertAtStart(head2, i);
    }
    System.out.println("LL2 - ");
    ll.printLL(head2);

    System.out.println("--- Self approach ---");
    ll.printLL(addTwoLists(head1, head2));
    System.out.println("--- GFG approach ---");
    ll.printLL(addTwoListsGFG(head1, head2));
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

  // ------------------------------------ GFG -------------------------
  // Function to reverse the linked list
  static Node reverse(Node head) {
    Node prev = null;
    Node curr = head;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  // Function to find the length of linked list
  static int countNodes(Node head) {
    int len = 0;
    Node curr = head;

    while (curr != null) {
      len += 1;
      curr = curr.next;
    }
    return len;
  }

  // function to trim leading zeros in linked list
  static Node trimLeadingZeros(Node head) {
    while (head != null && head.data == 0) {
      head = head.next;
    }
    return head;
  }

  // Function to add two numbers represented by linked list
  static Node addTwoListsGFG(Node num1, Node num2) {
    num1 = trimLeadingZeros(num1);
    num2 = trimLeadingZeros(num2);

    // Find the length of both the linked lists
    int len1 = countNodes(num1);
    int len2 = countNodes(num2);

    // If num1 is smaller, swap the two linked lists by
    // calling the function with reversed parameters
    if (len1 < len2) {
      return addTwoListsGFG(num2, num1);
    }

    int carry = 0;
    num1 = reverse(num1);
    num2 = reverse(num2);

    Node res = num1;

    // Iterate till either num2 is not empty or
    // carry is greater than 0
    while (num2 != null || carry != 0) {

      // Add carry to num1
      num1.data += carry;

      // If num2 linked list is not empty, add it to num1
      if (num2 != null) {
        num1.data += num2.data;
        num2 = num2.next;
      }

      // Store the carry for the next nodes
      carry = num1.data / 10;

      // Store the remainder in num1
      num1.data = num1.data % 10;

      // If we are at the last node of num1 but carry is
      // still left, then append a new node to num1
      if (num1.next == null && carry != 0) {
        num1.next = new Node(0);
      }

      num1 = num1.next;
    }

    // Reverse the resultant linked list to get the
    // required linked list
    return reverse(res);
  }

  // ============================================
}
