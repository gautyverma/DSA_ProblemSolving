package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.Arrays;

public class a7_ConstructBTUsingInPost {
  public static void main(String[] args) {
    int inorder[] = {4, 8, 2, 5, 1, 6, 3, 7}, postorder[] = {8, 4, 5, 2, 6, 7, 3, 1};
    Node root = buildTree(inorder, postorder);

    System.out.println(Arrays.toString(inorder));
    new OPS_Tree().inorderTraversal(root);
  }

  static int postIndex = 0;

  private static Node buildTree(int[] inorder, int[] postorder) {
    int indexStart = 0, indexEnd = inorder.length - 1;
    postIndex = indexEnd;
    return constructBT(inorder, postorder, indexStart, indexEnd);
  }

  private static Node constructBT(int[] inorder, int[] postorder, int indexStart, int indexEnd) {
    if (indexStart > indexEnd) return null;
    Node root = new Node(postorder[postIndex--]);

    int inIndex = 0;
    for (int i = indexStart; i <= indexEnd; i++) {
      if (inorder[i] == root.key) {
        inIndex = i;
        break;
      }
    }
    root.right = constructBT(inorder, postorder, inIndex + 1, indexEnd);
    root.left = constructBT(inorder, postorder, indexStart, inIndex - 1);

    return root;
  }
}
