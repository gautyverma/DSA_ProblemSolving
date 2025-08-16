package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class a8_ChildrenSumProperty {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTreeChildrenSum();
    System.out.println(isChildSumPropIterative(root));
    System.out.println("Recursive solution = ");
    System.out.println(isChildSumPropRecursive(root));
  }

  private static boolean isChildSumPropRecursive(Node root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) return true;
    int sum = 0;

    if (root.left != null) sum += root.left.data;
    if (root.right != null) sum += root.right.data;
    return root.data == sum
        && isChildSumPropRecursive(root.left)
        && isChildSumPropRecursive(root.right);
  }

  private static boolean isChildSumPropIterative(Node root) {
    System.out.println("Iterative solution = ");
    if (root == null) return true;
    else if (root.left == null && root.right == null) return true;
    else {
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      while (!q.isEmpty()) {
        int count = q.size();
        for (int i = 0; i < count; i++) {
          Node curr = q.poll();
          int temp = 0;
          if (curr.left == null && curr.right == null) {
            continue;
          }
          if (curr.left != null) {
            q.add(curr.left);
            temp += curr.left.data;
          } else temp += 0;

          if (curr.right != null) {
            q.add(curr.right);
            temp += curr.right.data;
          } else temp += 0;

          if (curr.data != temp) return false;
        }
      }
    }
    return true;
  }
}
