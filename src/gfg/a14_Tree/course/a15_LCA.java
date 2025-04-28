package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.ArrayList;
import java.util.Arrays;

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
    int n1 = 70, n2 = 80;
    System.out.println(findLowestCommonAncestorApp1(root, n1, n2).key);
  }

  private static Node findLowestCommonAncestorApp1(Node root, int n1, int n2) {
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) return null;

    for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
      if (path1.get(i + 1) != path2.get(i + 1)) {
        return path2.get(i);
      }
    }
    return null;
  }

  private static boolean findPath(Node root, ArrayList<Node> path, int n) {
    if (root == null) return false;
    path.add(root);
    if (root.key == n) return true;
    if (findPath(root.left, path, n) || findPath(root.right, path, n)) return true;
    path.remove(path.size() - 1);
    return false;
  }
}
