package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class a4_LevelOrderTraversal {
  public static void main(String[] args) {
    OPS_Tree t = new OPS_Tree();
    Node root = t.initializeTreeUsingInsertion();
    System.out.println("Naive Solution = ");
    t.levelOrderTraversalNaiveSol(root);
    System.out.println("Efficient Solution = ");
    printLevelOrder(root);
  }

  private static void printLevelOrder(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node curr = q.poll();
      System.out.print(curr.key + " ");

      if (curr.left != null) {
        q.add(curr.left);
      }
      if (curr.right != null) {
        q.add(curr.right);
      }
    }
  }
}
