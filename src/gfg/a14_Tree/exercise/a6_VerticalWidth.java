package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.HashSet;
/*
Given a Binary Tree. You need to find and return the vertical width of the tree.

Examples :

Input:
         1
       /    \
      2      3
     / \    /  \
    4   5  6   7
            \   \
             8   9
Output: 6
Explanation: The width of a binary tree is
the number of vertical paths in that tree.*

Approach - consider the tree on x-axis and get its size
* */
public class a6_VerticalWidth {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    System.out.println("Vertical width of tree :" + verticalWidth(root));
  }

  private static int verticalWidth(Node root) {
    HashSet<Integer> set = new HashSet<>();
    widthHelper(root, set, 0);
    return set.size();
  }

  private static void widthHelper(Node root, HashSet<Integer> set, int x) {
    if (root == null) return;
    widthHelper(root.left, set, x - 1);
    set.add(x);
    widthHelper(root.right, set, x + 1);
  }
}
