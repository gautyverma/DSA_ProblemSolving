package gfg.a15_BST.course;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;
import java.util.*;

/*
*
* node (horizontal_dist)
*
*           100(0)
          /        \
        60(-1)     120(+1)
       /     \       \
    40(-2)   80(0)     130(+2)
           /       \
        70(-1)    90(+1)
* */
public class a13_BottomViewBT {
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();

    System.out.println("\nBottom view : ");
    verticalOrder(root);
  }

  private static void verticalOrder(Node root) {
    Queue<PairBottomView> q = new LinkedList<>();
    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
    q.add(new PairBottomView(root, 0));
    while (!q.isEmpty()) {
      PairBottomView p = q.poll();
      int hd = p.hDist;
      Node curr = p.node;

      // Store the current node in the map at horizontal distance hd
      if (!map.containsKey(hd)) map.put(hd, new ArrayList<>());
      map.get(hd).add(curr.data);

      if (curr.left != null) q.add(new PairBottomView(curr.left, hd - 1));
      if (curr.right != null) q.add(new PairBottomView(curr.right, hd + 1));
    }

    ArrayList<Integer> res = new ArrayList<>();
    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      res.add(entry.getValue().getLast());
    }
    System.out.println(res);
  }
}

class PairBottomView {
  Node node;
  int hDist;

  PairBottomView(Node n, int hd) {
    node = n;
    hDist = hd;
  }
}
