package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a3_IdenticalTree {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    System.out.println(isIdentical(root, root));
  }

  private static boolean isIdentical(Node r1, Node r2) {
    if (r1 == null && r2 == null) return true;
    if (r1 == null || r2 == null) return false;
    // Check current node value + left and right subtree
    return (r1.key == r2.key)
            && isIdentical(r1.left, r2.left)
            && isIdentical(r1.right, r2.right);
  }
}
