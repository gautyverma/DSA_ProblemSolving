package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class a10_MaxWidthTree {
  public static void main(String[] args) {
    OPS_Tree t = new OPS_Tree();
    Node root = t.initializeTreeUsingInsertion();
    System.out.println(getMaxWidth(root));
  }

  private static int getMaxWidth(Node root) {
    if (root == null) return 0;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int res = 0;
    while (!q.isEmpty()) {
      int count = q.size();
      res = Math.max(res, count);
      for (int i = 0; i < count; i++) {
        Node curr = q.poll();
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
    }
    return res;
  }
}
