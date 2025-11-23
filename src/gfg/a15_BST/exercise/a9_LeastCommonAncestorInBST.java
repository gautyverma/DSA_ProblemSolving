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
public class a9_LeastCommonAncestorInBST {
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    System.out.println(getLCAInBST(root, 40, 90).data);
  }

  private static Node getLCAInBST(Node root, int n1, int n2) {
    while (root != null) {
      if (n1 < root.data && n2 < root.data) root = root.left;
      else if (n1 > root.data && n2 > root.data) root = root.right;
      else return root;
    }
    return null;
  }
}
