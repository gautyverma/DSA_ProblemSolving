package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

public class a2_BinaryTreeHeight {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();

    // 2. Height of Binary tree
    System.out.println("\n --- Height of tree ---");
    System.out.println(tree.heightOfBT(root));
  }
}
