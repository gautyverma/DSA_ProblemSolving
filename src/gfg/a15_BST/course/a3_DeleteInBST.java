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
public class a3_DeleteInBST {
  public static void main(String[] args) {
    OPS_BST bst = new OPS_BST();
    Node root = bst.initializeBST();
    bst.inorderTraversal(root);
    System.out.println("\n=== After Deletion ===");
    delNode(root, 100);
    bst.inorderTraversal(root);

    System.out.println("\n=== After Deletion ===");
    delNode(root, 120);
    bst.inorderTraversal(root);
  }

  private static Node delNode(Node root, int key) {
    if (root == null) return null;
    if (root.data > key) root.left = delNode(root.left, key);
    else if (root.data < key) root.right = delNode(root.right, key);
    else {
      if (root.left == null) return root.right;
      else if (root.right == null) return root.left;
      else {
        Node succ = getSucc(root);
        root.data = succ.data;
        root.right = delNode(root.right, succ.data);
      }
    }
    return root;
  }

  private static Node getSucc(Node root) {
    Node curr = root.right;
    while (curr != null & curr.left != null) {
      curr = curr.left;
    }
    return curr;
  }
}
