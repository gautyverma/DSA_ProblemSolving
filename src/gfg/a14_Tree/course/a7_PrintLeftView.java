package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class a7_PrintLeftView {
  static int maxLevel = 0;

  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    printLeftViewRecursive(root);
    printLeftViewIterative(root);
  }

  private static void printLeftViewIterative(Node root) {
    System.out.println("Iterative solution =");
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        Node curr = q.poll();
        if (i == 0) {
          System.out.print(curr.data + " ");
        }
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
    }
  }

  private static void printLeftViewRecursive(Node root) {
    System.out.println("Recursive solution =");
    printLeft(root, 1);
    System.out.println();
  }

  private static void printLeft(Node root, int level) {
    if (root == null) return;
    if (maxLevel < level) {
      System.out.print(root.data + " ");
      maxLevel = level;
    }
    printLeft(root.left, level + 1);
    printLeft(root.right, level + 1);
  }
}
