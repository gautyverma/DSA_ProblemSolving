package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a9_IsTreeBalanced {

  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTreeUsingInsertion();
    System.out.println("Naive Sol :");
    System.out.println(isTreeBalanceNaive(root));
    System.out.println("Efficient Sol :");
    System.out.println(isTreeBalanceEfficientSol(root));
  }

  private static int isTreeBalanceEfficientSol(Node root) {
    if (root == null) return 0;

    // Check for left subtree and get its height as well
    int lh = isTreeBalanceEfficientSol(root.left);
    if (lh == -1) return -1;

    // Check for right subtree and get its height as well
    int rh = isTreeBalanceEfficientSol(root.right);
    if (rh == -1) return -1;

    if (Math.abs(lh - rh) > 1) return -1;
    else return Math.max(lh, rh) + 1;
  }

  private static boolean isTreeBalanceNaive(Node root) {
    if (root == null) return true;
    int lh = height(root.left);
    int rh = height(root.right);

    return Math.abs(lh - rh) <= 1
        && isTreeBalanceNaive(root.left)
        && isTreeBalanceNaive(root.right);
  }

  private static int height(Node root) {
    if (root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
  }
}
