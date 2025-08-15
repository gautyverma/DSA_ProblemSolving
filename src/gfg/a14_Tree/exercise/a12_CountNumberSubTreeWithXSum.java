package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;
/*
*
*
*  You are given a root of  binary tree and an integer x. Your task is to count the number of subtrees whose sum of all node values is exactly equal to x.
Note: A subtree is formed by a node in the binary tree together with all of its descendants. The sum of a subtree is the sum of all node values within it.
Examples:
Input: root = [5, -10, 3, 9, 8, -4, 7 ], x = 7
Output: 2
Explanation: Subtrees with sum 7 are [9, 8, -10] and [7].
* */
public class a12_CountNumberSubTreeWithXSum {
  private static int count = 0;

  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    System.out.println(countSubTreeWithSumX(root, 200));
  }

  private static int countSubTreeWithSumX(Node root, int x) {
    count = 0;
    System.out.println(countSubTreeHelper(root, x));
    return count;
  }

  private static int countSubTreeHelper(Node node, int x) {
    if (node == null) return 0;
    int ls = countSubTreeHelper(node.left, x);
    int rs = countSubTreeHelper(node.right, x);
    int currentSubTreeSum = ls + rs + node.key;

    if (currentSubTreeSum == x) count++;
    return currentSubTreeSum;
  }
}
