package gfg.a14_Tree.exercise;

import java.util.ArrayList;
import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

/*
* Given an array parent that is used to represent a tree. The array indices (0-based indexing) are the
* values of the tree nodes and parent[i] denotes the parent node of a particular node.
* The parent of the root node would always be -1, as there is no parent for the root.
* Construct the standard linked representation of Binary Tree from this array representation and return the root node of the constructed tree.


* Note: If two elements have the same parent, the one that appears first in the array
* will be the left child and the other is the right child. You don't need to print anything,
* the driver code will print the level order traversal of the returned root node to verify the output.

Examples:

Input: parent[] = [-1, 0, 0, 1, 1, 3,5]
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6
*
*  [-1, 0, 0, 1, 1, 2, 2, 3, 4, 6, 6]
*
*             0
            /     \
          1         2
        /   \     /   \
      3      4   5     6
     /      /         / \
    7      8         9  10
* */
public class a9_ConstructBTFromparentArr {
  public static void main(String[] args) {
    int[] arr = {-1, 0, 0, 1, 1, 2, 2, 3, 4, 6, 6};
    int[] arr1 = {-1, 0, 0, 1, 1, 3, 5};
    Node root = createTree(arr1);
    OPS_Tree tree = new OPS_Tree();
    tree.inorderTraversal(root);
  }
  public static Node createTree(int[] parent) {
    int n = parent.length;
    Node[] nodes = new Node[n];
    Node root = null;

    // Step 1: Create all nodes
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i);
    }

    // Step 2: Connect children to their parents
    for (int i = 0; i < n; i++) {
      int par = parent[i];
      if (par == -1) {
        root = nodes[i];
      } else {
        Node pNode = nodes[par];
        if (pNode.left == null) {
          pNode.left = nodes[i];
        } else {
          pNode.right = nodes[i];
        }
      }
    }

    return root;
  }
/*

private static Node createTree(int[] arr) {
    int n = arr.length;
    if (n == 0) {
      return null;
    }
    ArrayList<Node> list = new ArrayList<>();
    int index = 0;
    list.add(new Node(index));
    int i = 1;
    while (i < n) {
      index = arr[i];
      Node node = list.get(index);
      Node left = new Node(i);
      list.add(left);
      if (i+1<n && arr[i] == arr[i + 1]) {
        Node right = new Node(i + 1);
        node.left = left;
        node.right = right;
        i += 2;
        list.add(right);
      } else {
        node.left = left;
        i += 1;
      }
    }
    return list.get(0);
  }*/
}
