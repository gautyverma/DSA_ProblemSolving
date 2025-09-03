package gfg.a15_BST.course;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

public class a8_isBST {
  private static int prev = Integer.MIN_VALUE;

  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    System.out.println("Efficient approach - 1 = " + isBSTEff1(root));
    System.out.println(
        "Efficient approach - 2 = " + isBSTEff2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }

  private static boolean isBSTEff2(Node root, int minValue, int maxValue) {
    if (root == null) return true;
    return (root.data > minValue
        && root.data < maxValue
        && isBSTEff2(root.left, minValue, root.data)
        && isBSTEff2(root.right, root.data, maxValue));
  }

  /*
  * A BT is BST if its inorderTraversal is in increasing order.
  * */
  private static boolean isBSTEff1(Node root) {
    if (root == null) return true;
    if (isBSTEff1(root.left) == false) return false;
    if (root.data <= prev) return false;
    prev = root.data;
    return isBSTEff1(root.right);
  }
}
