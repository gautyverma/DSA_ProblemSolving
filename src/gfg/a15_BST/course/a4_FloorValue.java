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
public class a4_FloorValue {
  public static void main(String[] args) {
    OPS_BST bst = new OPS_BST();
    Node root = bst.initializeBST();
    System.out.println("FloorValue: using recursion - " + floorRecursive(root, 85));
    System.out.println("FloorValue: using iter approach - " + floorIter(root, 85));
  }

  private static int floorIter(Node root, int key) {
    int floorValue = -1;
    while (root != null) {
      if (root.data == key) return root.data;
      if (root.data > key) root = root.left;
      else {
        floorValue = root.data;
        root = root.right;
      }
    }
    return floorValue;
  }

  private static int floorRecursive(Node root, int key) {
    if (root == null) return -1;
    if (root.data > key) return floorRecursive(root.left, key);
    int floorValue = floorRecursive(root.right, key);
    return (floorValue <= key && floorValue != -1) ? floorValue : root.data;
  }
}
