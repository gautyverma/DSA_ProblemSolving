package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.Arrays;

/*
 * Construct binary tree using in order
 * */
public class a12_ConstructBTUsingInPre {
  static int preIndex = 0;

  public static void main(String[] args) {
    int[] inorder = {3, 1, 4, 0, 5, 2};
    int[] preorder = {0, 1, 3, 4, 2, 5};
    int indexEnd = inorder.length - 1;
    int indexStart = 0;
    Node root = constructBT(inorder, preorder, indexStart, indexEnd);

    System.out.println(Arrays.toString(inorder));
    new OPS_Tree().inorderTraversal(root);
  }

  private static Node constructBT(int[] inorder, int[] preorder, int indexStart, int indexEnd) {
    if (indexStart > indexEnd) {
      return null;
    }
    Node root = new Node(preorder[preIndex++]);

/*   For postOrder - Get root from postorder (from end to start)
    Node root = new Node(postorder[postIndex--]);

    */

    int inIndex = 0;
    for (int i = indexStart; i <= indexEnd; i++) {
      if (inorder[i] == root.data) {
        inIndex = i;
        break;
      }
    }
    root.left = constructBT(inorder, preorder, indexStart, inIndex - 1);
    root.right = constructBT(inorder, preorder, inIndex + 1, indexEnd);
    return root;
  }
}
