package gfg.a15_BST.exercise;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

/*
* Given an array BST[] of size N containing level order traversal of a
* Binary Search Tree. The task is to complete the function constructBst(),
* which constructs the BST (Binary Search Tree) from its given level order traversal.

Example 1:

Input:
N = 9
BST[] = [7,4,12,3,6,8,1,5,10]
Output: 7 4 3 1 6 5 12 8 10
Explanation: After constructing BST, the
preorder traversal of BST is
7 4 3 1 6 5 12 8 10.*/
public class a7_ConstructBSTFromLevelOrder {
  public static void main(String[] args) {
    int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
    OPS_BST tree = new OPS_BST();
    tree.inorderTraversal(consturctBST(arr));
  }

  private static Node consturctBST(int[] arr) {

    Node root = null;
    for (int data : arr) root = levelOrder(root, data);
    return root;
  }

  private static Node levelOrder(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }
    if(data < root.data)
      root.left = levelOrder(root.left,data);
    else
      root.right = levelOrder(root.right,data);
    return root;
  }
}
