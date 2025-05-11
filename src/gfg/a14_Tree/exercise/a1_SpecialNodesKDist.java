package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
* Given a binary tree with n nodes and a non-negative integer k, the task is to count the number of special nodes.
A node is considered special if there exists at least one leaf in its subtree such that the distance between the node and leaf is exactly k.
Note: Any such node should be counted only once. For example, if a node is at a distance k from 2 or more leaf nodes, then it would add only 1 to our count.

Examples:

Input:
        1
      /   \
     2     3
   /  \   /  \
  4   5  6    7
          \
           8
k = 2
Output: 2

* Explanation: There are only two unique nodes that are at a distance of 2 units from the leaf node.
* (node 3 for leaf with value 8 and node 1 for leaves with values 4, 5 and 7)
* Note that node 2 isn't considered for leaf with value 8 because it isn't a direct ancestor of node 8.
* */

/*
*  Approach (Naive, Simple)
Use DFS traversal from the root.
Maintain a path list from the root to the current node.
When a leaf node is reached:
If path.size() > k, the node at index path.size() - k - 1 is a candidate special node.
Add its value to a Set (to avoid duplicates).
Backtrack after exploring each child.

Why the Path is Needed
To access the ancestor that is k steps above a leaf node without retracing from the root.
Allows constant-time access to the ancestor node during DFS.
* */
public class a1_SpecialNodesKDist {
  public static void main(String[] args) {
    /*
           Tree:
               1
              / \
             2   3
            / \ / \
           4  5 6  7
                    \
                     8
       k = 2 => Output: 2
    */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.right.right = new Node(8);

    int k = 2;
    System.out.println("res = " + printKDistantfromLeaf(root, k));
  }

  static HashSet<Node> special = new HashSet<>();

  private static int printKDistantfromLeaf(Node root, int k) {
    List<Node> path = new ArrayList<>();
    dfs(root, k, path);
    return special.size();
  }

  private static void dfs(Node root, int k, List<Node> path) {
    if (root == null) return;
    path.add(root);
    if (root.left == null && root.right == null) {
      if (path.size()-1 >= k) {
        Node ancestor = path.get(path.size() - k - 1);
        special.add(ancestor);
      }
    }

    dfs(root.left, k, path);
    dfs(root.right, k, path);
    path.remove(path.size() - 1);
  }
}
