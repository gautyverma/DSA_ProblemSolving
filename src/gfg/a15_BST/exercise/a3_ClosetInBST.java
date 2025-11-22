package gfg.a15_BST.exercise;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

/*
*
* Given a BST and an integer. Find the least absolute difference
* between any node value of the BST and the given integer.

Example 1:

Input:
        10
      /   \
     2    11
   /  \
  1    5
      /  \
     3    6
      \
       4
K = 13
Output: 2
Explanation: K=13. The node that has value nearest to K is 11. so the answer is 2
Example 2:

Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
K = 9
Output: 0
Explanation: K=9. The node that has value nearest to K is 9. so the answer is 0.*/
public class a3_ClosetInBST {

  /*
  *           100
            /    \
          60     120
         /  \       \
       40   80     130
            / \
          70   90
  * */
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    System.out.println(minDiff(root, 84));
  }

  private static int minDiff(Node root, int k) {
    int minDiff = Integer.MAX_VALUE;
    while (root != null) {
      int diff = Math.abs(root.data - k);
      minDiff = Math.min(minDiff, diff);

      if (k < root.data) root = root.left;
      else if (k > root.data) root = root.right;
      else return 0;
    }
    return minDiff;
  }
}
