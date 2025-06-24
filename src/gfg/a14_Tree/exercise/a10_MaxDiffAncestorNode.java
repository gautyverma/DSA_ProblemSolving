package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a10_MaxDiffAncestorNode {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    System.out.println(maxDiff(root));
  }

  static int diff;

  private static int maxDiff(Node root) {
    diff = Integer.MIN_VALUE;
    helper(root, root.key);
    return diff;
  }

  private static void helper(Node root, int maxAncestor) {
    if (root == null) return;
    diff = Math.max(diff, maxAncestor - root.key);
    int newMax = Math.max(maxAncestor, root.key);
    helper(root.left, newMax);
    helper(root.right, newMax);
  }
}
