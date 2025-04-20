package gfg.a14_Tree.common;

import java.util.LinkedList;
import java.util.Queue;

public class OPS_Tree {
  /*
  *           10
            /    \
          20      30
         /  \       \
       40   50       60
            / \
          70   80
  * */
  public Node initializeTree() {
    Node root = new Node(10);
    // left subtree
    root.left = new Node(20);
    root.left.left = new Node(40);
    root.left.right = new Node(50);

    root.left.right.left = new Node(70);
    root.left.right.right = new Node(80);

    // right subtree
    root.right = new Node(30);
    root.right.right = new Node(60);
    return root;
  }

  /*
            10
          /    \
        20      30
       /  \    /  \
     40   50  60  70
  */

  public Node initializeTreeUsingInsertion() {
    Node root = insertNodeAtLevel(null, 10);
    root = insertNodeAtLevel(root, 20);
    root = insertNodeAtLevel(root, 30);
    root = insertNodeAtLevel(root, 40);
    root = insertNodeAtLevel(root, 50);
    root = insertNodeAtLevel(root, 60);
    root = insertNodeAtLevel(root, 70);
    return root;
  }

  private Node insertNodeAtLevel(Node root, int data) {

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

  public void preorderTraversal(Node root) {
    if (root != null) {
      System.out.print(root.key + " ");
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  public void postorderTraversal(Node root) {
    if (root != null) {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      System.out.print(root.key + " ");
    }
  }

  public int heightOfBT(Node root) {
    if (root == null) return 0;
    return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
  }

  /*
   * approach - 1
   * 1. Get the height of tree
   * 2. loop over the height and printKdist which prints all nodes at specific level
   * */
  public void levelOrderTraversalNaiveSol(Node root) {
    int heightOfTree = heightOfBT(root);
    for (int i = 0; i < heightOfTree; i++) {
      printKDist(root, i);
      System.out.println();
    }
  }

  private void printKDist(Node root, int k) {
    if (root == null) return;
    if (k == 0) {
      System.out.print(root.key + " ");
    } else {
      printKDist(root.left, k - 1);
      printKDist(root.right, k - 1);
    }
  }

  public int getSizeBt(Node root) {
    if (root == null) return 0;
    return 1 + getSizeBt(root.left) + getSizeBt(root.right);
  }
}
