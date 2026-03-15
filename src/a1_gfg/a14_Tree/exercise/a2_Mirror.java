package a1_gfg.a14_Tree.exercise;

import a1_gfg.a14_Tree.common.Node;
import a1_gfg.a14_Tree.common.OPS_Tree;

public class a2_Mirror {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    tree.inorderTraversal(root);
    mirror(root);
    System.out.println();
    tree.inorderTraversal(root);
  }

  private static void mirror(Node root) {
    if (root == null) return;
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
    mirror(root.left);
    mirror(root.right);
  }
}
