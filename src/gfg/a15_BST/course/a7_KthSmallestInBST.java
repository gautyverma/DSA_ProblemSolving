package gfg.a15_BST.course;

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
public class a7_KthSmallestInBST {
  private static int count = 0;

  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    printKthSmall(root, 3);
  }

  private static void printKthSmall(Node root, int k) {
    if (root != null) {
      printKthSmall(root.left, k);
      count++;
      if (count == k) {
        System.out.println(root.data);
        return;
      }
      printKthSmall(root.right, k);
    }
  }
}
