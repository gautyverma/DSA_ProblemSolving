package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

/*
*           10
          /    \
        20      30
       /  \       \
     40   50       60
          / \
        70   80
* */
public class a14_DiameterOfBT {
  private static int res = 0;

  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    System.out.println("Diameter of BT : " + diameterOfBT(root));
    heightBTDiameter(root);
    System.out.println("Height based function for diameter of BT : " + res);
  }

  private static int diameterOfBT(Node root) {

    if (root == null) return 0;
    int d1 = 1 + heightBT(root.left) + heightBT(root.right);
    int d2 = heightBT(root.left);
    int d3 = heightBT(root.right);

    return Math.max(d1, Math.max(d3, d2));
  }

  private static int heightBT(Node root) {
    if (root == null) return 0;
    return 1 + Math.max(heightBT(root.left), heightBT(root.right));
  }

  private static int heightBTDiameter(Node root) {
    if (root == null) return 0;
    int lh = heightBTDiameter(root.left);
    int rh = heightBTDiameter(root.right);

    res = Math.max(res, 1 + lh + rh);
    return 1 + Math.max(lh, rh);
  }
}
