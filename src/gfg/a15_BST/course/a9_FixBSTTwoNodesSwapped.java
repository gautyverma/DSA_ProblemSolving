package gfg.a15_BST.course;

import gfg.a15_BST.common.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class a9_FixBSTTwoNodesSwapped {
  public static void main(String[] args) {
    System.out.println("== Naive Solution ==");
    Node root = getTree();
    correctBST(root);
    printLevelOrder(root);

    System.out.println("\n== Efficient Solution ==");

    Node root1 = getTree();
    correctBSTEff(root1);
    printLevelOrder(root1);
  }

  // --- Efficient solution - start

  static Node first = null;
  static Node second = null;
  static Node prev = null;

  // Inorder traversal to find swapped nodes
  static void correctBSTUtil(Node root) {
    if (root == null) return;

    // Left subtree
    correctBSTUtil(root.left);

    // Detect violation
    if (prev != null && root.data < prev.data) {
      if (first == null) {
        first = prev; // first wrong node
      }
      second = root; // second wrong node (updated even if second violation)
    }

    prev = root; // update previous

    // Right subtree
    correctBSTUtil(root.right);
  }

  static void correctBSTEff(Node root) {
    correctBSTUtil(root);

    // Fix the swapped nodes
    if (first != null && second != null) {
      int temp = first.data;
      first.data = second.data;
      second.data = temp;
    }
  }

  // --- Efficient solution - end

  private static Node getTree() {

    // Constructing the tree with swapped nodes
    //       6
    //     /  \
    //    10   2
    //   / \  / \
    //  1  3 7  12
    // Here, 10 and 2 are swapped

    Node root = new Node(6);
    root.left = new Node(10);
    root.right = new Node(2);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.right = new Node(12);
    root.right.left = new Node(7);

    return root;
  }

  // Print tree as level order
  static void printLevelOrder(Node root) {
    if (root == null) {
      System.out.print("N ");
      return;
    }

    Queue<Node> qq = new LinkedList<>();
    qq.add(root);
    int nonNull = 1;

    while (!qq.isEmpty() && nonNull > 0) {
      Node curr = qq.poll();

      if (curr == null) {
        System.out.print("N ");
        continue;
      }
      nonNull--;

      System.out.print(curr.data + " ");
      qq.add(curr.left);
      qq.add(curr.right);
      if (curr.left != null) nonNull++;
      if (curr.right != null) nonNull++;
    }
  }

  // Function to fix the given BST where two nodes are swapped.
  static void correctBST(Node root) {

    // Array to store the inorder traversal of the tree
    ArrayList<Integer> inorder = new ArrayList<>();
    findInorder(root, inorder);

    // Sort the array to get the correct order of
    // elements in a BST
    Collections.sort(inorder);

    int[] index = {0};
    correctBSTUtil(root, inorder, index);
  }

  // Function to store the inorder traversal of the tree in an array
  static void findInorder(Node curr, ArrayList<Integer> inorder) {
    if (curr == null) return;

    // Recursively store left subtree
    findInorder(curr.left, inorder);

    // Store the current node's data
    inorder.add(curr.data);

    // Recursively store right subtree
    findInorder(curr.right, inorder);
  }

  // Recursive function to correct the BST by replacing
  // node values with sorted values
  static void correctBSTUtil(Node root, ArrayList<Integer> inorder, int[] index) {
    if (root == null) return;

    // Recursively fill the left subtree
    correctBSTUtil(root.left, inorder, index);

    // Replace the current node's data with
    // the correct value from the sorted array
    root.data = inorder.get(index[0]);
    index[0]++;

    // Recursively fill the right subtree
    correctBSTUtil(root.right, inorder, index);
  }
}
