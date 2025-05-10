package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.Stack;

public class a19_TreeIterativeTraversal {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    System.out.println("\nrecursive inorder traversal");
    tree.inorderTraversal(root);
    System.out.println("\niterative Inorder tree traversal:");
    inorderIterTraversal(root);
    System.out.println("\n----------------");
    System.out.println("\nrecursive preorder traversal");
    tree.preorderTraversal(root);
    System.out.println("\niterative preorder tree traversal:");
    preorderIterTraversal(root);
    System.out.println("\niterative preorder tree traversal: space optimize");
    preorderIterTraversalEff(root);
  }

  private static void inorderIterTraversal(Node root) {}

  private static void preorderIterTraversal(Node root) {
    Stack<Node> st = new Stack<>();
    st.push(root);
    while (!st.isEmpty()) {
      Node curr = st.pop();
      System.out.print(curr.key + " ");
      if (curr.right != null) st.push(curr.right);
      if (curr.left != null) st.push(curr.left);
    }
  }

  private static void preorderIterTraversalEff(Node root) {
    Stack<Node> st = new Stack<>();
    st.push(root);
    Node curr = root;
    while (!st.isEmpty()) {
      while (curr != null) {
        System.out.print(curr.key + " ");
        if (curr.right != null) st.push(curr.right);
        curr = curr.left;
      }
      curr = st.pop();
    }
  }
}
