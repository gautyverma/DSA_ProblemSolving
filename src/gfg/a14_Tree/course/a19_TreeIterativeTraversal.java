package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.Stack;

public class a19_TreeIterativeTraversal {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    tree.inorderTraversal(root);
    System.out.println("\nInorder tree traversal:");
    inorderIterTraversal(root);
  }

  private static void inorderIterTraversal(Node root) {
    Stack<Node> st = new Stack<>();
    Node curr = root;
    while (curr != null || !st.isEmpty()) {
      while (curr != null) {
        st.push(curr);
        curr = curr.left;
      }
      curr = st.pop();
      System.out.print(curr.key + " ");
      curr = curr.right;
    }
  }
}
