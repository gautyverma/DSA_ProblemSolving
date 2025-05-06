package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a17_CountNodes {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTreeUsingInsertion();
    System.out.println("Number of nodes in BT: " + countNodes(root));
    System.out.println("Number of nodes in BT using eff solution: " + countNodesEff(root));
  }

  private static int countNodesEff(Node root) {
    if (root == null) return 0;
    int lh = 0, rh = 0;
    Node curr = root;
    while (curr != null) {
      lh++;
      curr = curr.left;
    }
    curr = root;
    while (curr != null) {
      rh++;
      curr = curr.right;
    }
    if (lh == rh) {
      return (int) (Math.pow(2, lh) - 1);
    }
    return 1 + countNodesEff(root.left) + countNodesEff(root.right);
  }

  private static int countNodes(Node root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
