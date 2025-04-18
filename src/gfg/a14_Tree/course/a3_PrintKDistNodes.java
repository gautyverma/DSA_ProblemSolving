package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a3_PrintKDistNodes {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();

    System.out.println("\n --- Nodes at distance K ---");
    printKDist(root, 2);
  }

  private static void printKDist(Node root, int k) {
    if (root == null) return;
    if (k == 0) {
      System.out.print(root.key + " ");
    } else {
      printKDist(root.left, k - 1);
      printKDist(root.right, k - 1);
    }
  }
}
