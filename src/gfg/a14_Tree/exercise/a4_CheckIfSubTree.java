package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a4_CheckIfSubTree {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    System.out.println(isSubtree(root, root));
  }

  public static int isSubtree(Node T, Node S) {
    return isSubtreeHelper(T, S) ? 1 : 0;
  }

  private static boolean isSubtreeHelper(Node T, Node S) {
    if (S == null) return true;
    if (T == null) return false;

    if (isIdentical(T, S)) return true;

    return isSubtreeHelper(T.left, S) || isSubtreeHelper(T.right, S);
  }

  // Identical tree logic
  private static boolean isIdentical(Node r1, Node r2) {
    if (r1 == null && r2 == null) return true;
    if (r1 == null || r2 == null) return false;
    return r1.key == r2.key && isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
  }
}
