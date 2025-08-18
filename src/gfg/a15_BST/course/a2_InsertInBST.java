package gfg.a15_BST.course;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

public class a2_InsertInBST {
  public static void main(String[] args) {
    OPS_BST bst = new OPS_BST();
    Node root = bst.initializeBST();
    bst.inorderTraversal(root);
    System.out.println("\n================");
    insertKeyEnd(root, 200);
    bst.inorderTraversal(root);
  }

  private static Node insertKeyEnd(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }
    if(root.data > key){
        root.left = insertKeyEnd(root.left,key);
    }
    else if(root.data < key){
        root.right = insertKeyEnd(root.right,key);
    }
    return root;
  }
}
