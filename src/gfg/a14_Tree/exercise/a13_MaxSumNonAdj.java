package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;

import java.util.HashMap;
/*
*
* Given a root of binary tree with a value associated with each node.
* Your task is to select a subset of nodes such that the sum of their values is maximized,
* with the condition that no two selected nodes are directly connected that is,
* if a node is included in the subset, neither its parent nor its children can be included.
*
* */
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

    System.out.println("==== Naive Solution ====");
    System.out.println(getMaxSumNaive(root));

    System.out.println("==== Approach Effective using hashmap ====");
    System.out.println(getMaxSumEff1(root));
  }

  private static int getMaxSumEff1(Node root) {
    if (root == null) return 0;
    HashMap<Node, Integer> memo = new HashMap<>();
    return sumUtilEff1(root, memo);
  }

  private static int sumUtilEff1(Node node, HashMap<Node, Integer> memo) {
    if (node == null) {
      return 0;
    }
    if (memo.containsKey(node)) {
      return memo.get(node);
    }
    int incl = node.data;
    if (node.left != null) {
      incl += sumUtilEff1(node.left.left,memo) + sumUtilEff1(node.left.right,memo);
    }
    if (node.right != null) {
      incl += sumUtilEff1(node.right.left,memo) + sumUtilEff1(node.right.right,memo);
    }
    int excl = 0;
    if (node.left != null) {
      excl += sumUtilEff1(node.left,memo);
    }
    if (node.right != null) {
      excl += sumUtilEff1(node.right,memo);
    }

    memo.put(node, Math.max(incl, excl));
    return memo.get(node);
  }

  private static int getMaxSumNaive(Node root) {
    if (root == null) return 0;
    return sumUtilNaive(root);
  }

  private static int sumUtilNaive(Node node) {
    if (node == null) {
      return 0;
    }
    int incl = node.data;
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
