package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a1_BinaryTreeTraverse {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    // 1. Traversal
    System.out.println("\n --- Inorder --- ");
    tree.inorderTraversal(root);
    System.out.println("\n --- preorder --- ");
    tree.preorderTraversal(root);
    System.out.println("\n --- postorder --- ");
    tree.postorderTraversal(root);
  }
}
