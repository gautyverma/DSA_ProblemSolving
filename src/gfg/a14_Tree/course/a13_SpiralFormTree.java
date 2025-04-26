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
    printSpiralForm(root);
  }

  private static void printSpiralForm(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    Stack<Integer> s = new Stack<>();
    Boolean reverse = false;

    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        Node curr = q.poll();
        if (reverse) s.push(curr.key);
        else System.out.print(curr.key + " ");

        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
      if (reverse) {
        while (!s.isEmpty()) {
          System.out.print(s.pop() + " ");
        }
      }
      reverse = !reverse;
      System.out.println();
    }
  }
}
