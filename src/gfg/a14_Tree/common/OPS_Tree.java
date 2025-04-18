package gfg.a14_Tree.common;

import java.util.LinkedList;
import java.util.Queue;

public class OPS_Tree {

  public Node initializeTree() {
    Node root = insertNode(null, 10);
    root = insertNode(root, 20);
    root = insertNode(root, 30);
    root = insertNode(root, 40);
    root = insertNode(root, 50);
    root = insertNode(root, 60);
    root = insertNode(root, 70);
    return root;
  }

  private Node insertNode(Node root, int data) {

    if (root == null) {
      return new Node(data);
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      // In a queue data structure, the poll() method retrieves and removes the head
      // (first element) of the queue.
      Node curr = q.poll();

      // First check left if left is null insert
      // node in left otherwise check for right
      if (curr.left != null) {
        q.add(curr.left);
      } else {
        curr.left = new Node(data);
        return root;
      }

      if (curr.right != null) {
        q.add(curr.right);
      } else {
        curr.right = new Node(data);
        return root;
      }
    }

    return root;
  }

  public void inorderTraversal(Node root) {
    if (root != null) {
      inorderTraversal(root.left);
      System.out.print(root.key + " ");
      inorderTraversal(root.right);
    }
  }
}
