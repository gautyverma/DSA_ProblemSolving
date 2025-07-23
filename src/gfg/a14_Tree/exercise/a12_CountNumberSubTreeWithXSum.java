package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

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
