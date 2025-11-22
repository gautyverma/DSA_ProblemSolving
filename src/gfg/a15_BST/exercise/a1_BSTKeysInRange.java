package gfg.a15_BST.exercise;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;
import java.util.ArrayList;

/*
*           100
          /    \
        60     120
       /  \       \
     40   80     130
          / \
        70   90
* */

public class a1_BSTKeysInRange {
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    int low = 40, high = 90;
    System.out.println(printNearNodes(root, low, high));
  }

  private static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
    ArrayList<Integer> res = new ArrayList<>();
    getKeysInRangeUtil(root, low, high, res);
    return res;
  }

  private static void getKeysInRangeUtil(Node root, int low, int high, ArrayList<Integer> res) {

    if (root == null) return;
    if (root.data > low) getKeysInRangeUtil(root.left, low, high, res);
    if (root.data >= low && root.data <= high) res.add(root.data);
    if (root.data < high) getKeysInRangeUtil(root.right, low, high, res);
  }
}
