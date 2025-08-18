package gfg.a15_BST.course;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

public class a1_SearchInBST {
  public static void main(String[] args) {
    OPS_BST bst = new OPS_BST();
    Node root = bst.initializeBST();
    System.out.println(bst.seachinBST(root, 150));
  }
}
