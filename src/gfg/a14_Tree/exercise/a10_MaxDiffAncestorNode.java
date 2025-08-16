package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a10_MaxDiffAncestorNode {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    //    System.out.println(maxDiff(root));
    System.out.println(maxDiffN(root));
  }

  static int maxDiffUtil(Node node, Res res) {
    if (node == null) return Integer.MAX_VALUE;
    if (node.left == null && node.right == null) return node.data;

    int val = Math.min(maxDiffUtil(node.left, res), maxDiffUtil(node.right, res));

    res.r = Math.max(res.r, node.data - val);
    return Math.min(val, node.data);
  }

  static int maxDiffN(Node root) {
    Res res = new Res();
    maxDiffUtil(root, res);
    return res.r;
  }

  /*
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
  */
}

/* Class Res created to implement pass by reference
of 'res' variable */
class Res {
  int r = Integer.MIN_VALUE;
}
