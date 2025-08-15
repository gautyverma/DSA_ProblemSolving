package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;

public class a13_MaxSumNonAdj {
  public static void main(String[] args) {

    // Creating a binary tree with the following structure:
    //          1
    //         / \
    //        3   3
    //       /   / \
    //      1   4   5

    Node root = new Node(1);
    root.left = new Node(3);
    root.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(5);
    root.left.left = new Node(1);

    System.out.println(getMaxSumNaive(root));
  }

  private static int getMaxSumNaive(Node root) {
    if (root == null) return 0;
    return sumUtilNaive(root);
  }

  private static int sumUtilNaive(Node node) {
    if (node == null) {
      return 0;
    }
    int incl = node.key;
    if (node.left != null) {
      incl += sumUtilNaive(node.left.left) + sumUtilNaive(node.left.right);
    }
    if (node.right != null) {
      incl += sumUtilNaive(node.right.left) + sumUtilNaive(node.right.right);
    }
    int excl = 0;
    if (node.left != null) {
      excl += sumUtilNaive(node.left);
    }
    if (node.right != null) {
      excl += sumUtilNaive(node.right);
    }

    return Math.max(incl, excl);
  }
}
