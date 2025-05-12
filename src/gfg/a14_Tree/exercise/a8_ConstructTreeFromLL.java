package gfg.a14_Tree.exercise;

import gfg.a10_LinkedList.common.OPS_LL;

import java.util.ArrayList;

public class a8_ConstructTreeFromLL {
  public static void main(String[] args) {

    Node head = new Node(10);
    Node n1 = new Node(20);
    Node n2 = new Node(30);
    Node n3 = new Node(40);
    Node n4 = new Node(50);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
  }

  private static Tree linkedListToBinaryTree(Node head) {
    if (head == null) return null;
    ArrayList<Tree> nodes = new ArrayList<>();
    Node curr = head;
    while (curr != null) {
      nodes.add(new Tree(curr.data));
      curr = curr.next;
    }

    for (int i = 0; i < nodes.size(); i++) {
      int leftIndex = 2 * i + 1;
      int rightIndex = 2 * i + 2;
      if (leftIndex < nodes.size()) nodes.get(i).left = nodes.get(leftIndex);
      if (rightIndex < nodes.size()) nodes.get(i).right = nodes.get(rightIndex);
    }
    return nodes.get(0);
  }
}

class Tree {
  int data;
  Tree left;
  Tree right;

  Tree(int d) {
    data = d;
    left = null;
    right = null;
  }
}

// Linked List Node class
class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}
