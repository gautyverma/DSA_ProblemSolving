package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

    /*
    Input -
              10
            /    \
          20      30
         /  \    /  \
       40   50  60  70

     Output -
     40 20 50 10 60 30 70

    1. Process left subtree
    2. process curr and prev node
    3. Process right subtree

    */

public class a11_ConvertBTToDLL {
  static Node prev = null;

  public static void main(String[] args) {
    OPS_Tree t = new OPS_Tree();
    Node root = t.initializeTreeUsingInsertion();
    printDLL(convertBtToDLL(root));
  }

  private static void printDLL(Node root) {
    Node curr = root;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.right;
    }
  }

  private static Node convertBtToDLL(Node root) {
    if (root == null) return root;
    Node head = convertBtToDLL(root.left);

    if (prev == null) head = root;
    else {
      prev.right = root;
      root.left = prev;
    }
    prev = root;
    convertBtToDLL(root.right);
    return head;
  }
}
