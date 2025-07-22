package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;

/*
*
* Given a binary tree, check if the tree can be folded or not.
* A tree can be folded if left and right subtrees
* of the tree are structure wise mirror image of each other.
* An empty tree is considered as foldable.

Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.


(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
* */
public class a5_FoldableBT {
  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(7);
    root.right = new Node(15);
    root.left.left = new Node(9);
    root.right.right = new Node(11);
    System.out.println(IsFoldable(root));
  }

  private static boolean IsFoldable(Node root) {
    if(root == null)
      return true;
    return isMirrorStr(root.left,root.right);
  }

  private static boolean isMirrorStr(Node a, Node b) {
  if(a == null && b==null)return true;
    if(a == null || b==null)return false;
    return isMirrorStr(a.left,b.right) && isMirrorStr(a.right,b.left);
  }
}
