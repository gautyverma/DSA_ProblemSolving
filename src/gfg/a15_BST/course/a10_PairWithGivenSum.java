package gfg.a15_BST.course;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

import java.util.HashSet;

/*
*           100
          /    \
        60     120
       /  \       \
     40   80     130
          / \
        70   90
* */
public class a10_PairWithGivenSum {
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    System.out.println("Pair of given sum is present : " + isPairSum(root, 210));
  }

  private static boolean isPairSum(Node root, int sum) {
    HashSet<Integer> s = new HashSet();
    return isPairSumUtil(root, sum, s);
  }

  private static boolean isPairSumUtil(Node root, int sum, HashSet<Integer> s) {
    if (root == null) return false;
    if (isPairSumUtil(root.left, sum, s) == true) return true;
    if (s.contains(sum - root.data)) return true;
    else s.add(root.data);
    return isPairSumUtil(root.right, sum, s);
  }
}
