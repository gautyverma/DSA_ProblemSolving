package gfg.a15_BST.exercise;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

/*
*           100
          /    \
        60     120
       /  \       \
     40   80     130
          / \
        70   90
* */
public class a6_CountBSTNodesInRange {
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    System.out.println(getCount(root, 50, 90));
  }

  private static int getCount(Node root, int l, int h) {
    if (root == null) return 0;

    // If root is in range
    if (root.data >= l && root.data <= h) {
      return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
    }

    // If root is smaller than l → ignore LEFT subtree
    if (root.data < l) {
      return getCount(root.right, l, h);
    }

    // If root is greater than h → ignore RIGHT subtree
    return getCount(root.left, l, h);
  }
}
