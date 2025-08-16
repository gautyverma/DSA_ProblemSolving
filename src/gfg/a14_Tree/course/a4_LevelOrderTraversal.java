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

    System.out.println("Efficient Solution = By line approach - 1");
    printLevelOrderLineApp1(root);

    System.out.println("Efficient Solution = By line approach - 2");
    printLevelOrderLineApp2(root);
  }

  private static void printLevelOrder(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node curr = q.poll();
      System.out.print(curr.data + " ");

      if (curr.left != null) {
        q.add(curr.left);
      }
      if (curr.right != null) {
        q.add(curr.right);
      }
    }
    System.out.println();
  }

  private static void printLevelOrderLineApp1(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (q.size() > 1) {
      Node curr = q.poll();
      if (curr == null) {
        System.out.println();
        q.add(null);
        continue;
      }
      System.out.print(curr.data + " ");

      if (curr.left != null) {
        q.add(curr.left);
      }
      if (curr.right != null) {
        q.add(curr.right);
      }
    }
    System.out.println();
  }

  private static void printLevelOrderLineApp2(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        Node curr = q.poll();
        System.out.print(curr.data + " ");
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
      System.out.println("\n----");
    }
  }
}
