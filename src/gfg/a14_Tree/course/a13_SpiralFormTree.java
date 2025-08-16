package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class a13_SpiralFormTree {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    printSpiralFormApp1(root);
    System.out.println("\nTwo stack approach : ");
    printSpiralFormApp2(root);
  }

  /*
   * Using two stack
   *   1. push root to stack s1
   *   2. While any of two stacks are empty
   *       ==> while s1 is not empty
   *         a) take out a node print it.
   *         b) push taken out node children to s2
   *
   *       ==> while s2 is not empty
   *         a) take out a node print it.
   *         b) push children of taken out node into s1 in reverse order
   * */
  private static void printSpiralFormApp2(Node root) {
    if (root == null) return;
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();

    s1.push(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {
      while (!s1.isEmpty()) {
        Node curr = s1.pop();
        System.out.print(curr.data + " ");

        if (curr.left != null) s2.push(curr.left);
        if (curr.right != null) s2.push(curr.right);
      }
      while (!s2.isEmpty()) {
        Node curr = s2.pop();
        System.out.print(curr.data + " ");

        if (curr.right != null) s1.push(curr.right);
        if (curr.left != null) s1.push(curr.left);
      }
    }
  }

  private static void printSpiralFormApp1(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    Stack<Integer> s = new Stack<>();
    Boolean reverse = false;

    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        Node curr = q.poll();
        if (reverse) s.push(curr.data);
        else System.out.print(curr.data + " ");

        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
      if (reverse) {
        while (!s.isEmpty()) {
          System.out.print(s.pop() + " ");
        }
      }
      reverse = !reverse;
      //      System.out.println();
    }
  }
}
