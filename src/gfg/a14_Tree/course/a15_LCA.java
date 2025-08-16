package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.ArrayList;
import java.util.List;

/*
*           10
          /    \
        20      30
       /  \       \
     40   50       60
          / \
        70   80
* */
public class a15_LCA {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    int n1 = 40, n2 = 80;
    System.out.println(findLowestCommonAncestorApp1(root, n1, n2).data);
  }

  private static Node findLowestCommonAncestorApp1(Node root, int n1, int n2) {
    // to store paths to n1 and n2 from the root
    List<Node> path1 = new ArrayList<>();
    List<Node> path2 = new ArrayList<>();

    // Find paths from root to n1 and
    // root to n2. If either
    // n1 or n2 is not present, return null.
    if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) return null;

    // Compare the paths to get the first
    // different value
    int i;
    for (i = 0; i < path1.size() && i < path2.size(); i++) {
      if (path1.get(i) != path2.get(i)) return path1.get(i - 1);
    }

    // if both the datas are same, return last node
    return path1.get(i - 1);
  }

  private static boolean findPath(Node root, List<Node> path, int n) {
    if (root == null) return false;
    path.add(root);
    if (root.data == n) return true;
    if (findPath(root.left, path, n) || findPath(root.right, path, n)) return true;
    path.remove(path.size() - 1);
    return false;
  }
}
