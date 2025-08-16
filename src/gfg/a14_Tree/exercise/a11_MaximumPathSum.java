package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a11_MaximumPathSum {
  public static void main(String[] args) {

    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTreeUsingInsertion();
    System.out.println(maxPathSum(root));
  }

  private static int maxPathSum(Node root) {
    int[] res = {root.data};
    maxPathSumUtil(root, res);
    return res[0];
  }

  private static int maxPathSumUtil(Node node, int[] res) {

    if (node == null) return 0;
    int l = Math.max(0, maxPathSumUtil(node.left, res));
    int r = Math.max(0, maxPathSumUtil(node.right, res));
    res[0] = Math.max(res[0], l + r + node.data);
    return node.data + Math.max(l, r);
  }
}
