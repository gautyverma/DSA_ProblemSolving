package gfg.a10_LinkedList.exercise.mediumHard;

import java.util.HashMap;

public class a11_CloneWithRandomPointer {
  public static void main(String[] args) {
    Node head = new Node(10);
    Node n2 = new Node(5);
    Node n3 = new Node(20);
    Node n4 = new Node(15);
    Node n5 = new Node(20);

    head.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    head.random = n3;
    n3.random = head;
    n2.random = n4;
    n4.random = n3;
    n5.random = n4;

    printll(head);
    printll(cloneLinkedListNaive(head));
    printll(cloneLinkedListEff(head));
  }

  /*
   * Approach 2 -
   * Create the copy of node 1 and insert it between node 1 and node 2 in the original Linked List,
   * create the copy of node 2 and insert it between 2nd and 3rd node and so on. Add the copy of N after the Nth node
   * Connect the clone node by updating the random pointers.
   * Separate the cloned linked list from the original list by updating the next pointers.
   *
   * */
  private static Node cloneLinkedListEff(Node head) {
    Node curr = head;
    // step - 1 - Insert clone nodes alternatively
    while (curr != null) {
      Node next = curr.next;
      curr.next = new Node(curr.data);
      curr.next.next = next;
      curr = next;
    }
    System.out.println("step 1 - Insert clone node alternatively");
    printll(head);

    // step - 2 - connect clone nodes with random
    for (curr = head; curr != null; curr = curr.next.next) {
      // curr.random.next - curr ki random ka next -> clone node
      curr.next.random = (curr.random == null) ? null : curr.random.next;
    }
    // step - 3 - separate the original and clone nodes using two heads
    Node head2 = head.next;
    Node clone = head2;
    curr = head;
    while (clone.next != null) {
      curr.next = curr.next.next; // skipping clone node and connect original
      clone.next = clone.next.next; // skipping original node and connect clone

      curr = curr.next;
      clone = clone.next;
    }
    curr.next = null;
    clone.next = null;

    return head2;
  }

  // approach - 1 - using hasMap
  /*
    * Steps to clone a linked list with next and random pointer:

  Create a hash table, say mp to store the new nodes corresponding to their original nodes.
  Traverse the original linked list and for every node, say curr,
  Create a new node corresponding to curr and push them into a hash table, mp[curr] = new Node().
  Again traverse the original linked list to update the next and random pointer of each new node, mp[curr]->next = mp[curr->next] and mp[curr]->random = mp[curr->random].
  Return mp[head] as the head of the cloned linked list.
    * */
  private static Node cloneLinkedListNaive(Node head) {
    HashMap map = new HashMap();
    Node curr = head;
    while (curr != null) {
      map.put(curr, new Node(curr.data));
      curr = curr.next;
    }
    curr = head;
    while (curr != null) {
      Node clone = (Node) map.get(curr);
      clone.next = (Node) map.get(curr.next);
      clone.random = (Node) map.get(curr.random);
      curr = curr.next;
    }
    // map.get(head) - head(key) -> new Node cloned data will be passed
    return (Node) map.get(head);
  }

  private static void printll(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}

class Node {
  int data;
  Node random;
  Node next;

  Node(int x) {
    data = x;
    random = null;
    next = null;
  }
}
