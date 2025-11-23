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
public class a12_VerticalTraversalInBT {
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    System.out.println("\nUnordered way : ");
    verticalTraversal(root);

    System.out.println("\nOrdered way : ");
    verticalOrder(root);
  }

  private static void verticalOrder(Node root) {
    Queue<PairTraversal> q = new LinkedList<>();
    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
    q.add(new PairTraversal(root, 0));
    while (!q.isEmpty()) {
      PairTraversal p = q.poll();
      int hd = p.hDist;
      Node curr = p.node;

      // Store the current node in the map at horizontal distance hd
      if (!map.containsKey(hd)) map.put(hd, new ArrayList<>());
      map.get(hd).add(curr.data);

      if (curr.left != null) q.add(new PairTraversal(curr.left, hd - 1));
      if (curr.right != null) q.add(new PairTraversal(curr.right, hd + 1));
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    // Properly typed Map.Entry
    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      res.add(entry.getValue());
    }

    System.out.println(res);
  }

  private static void verticalTraversal(Node root) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    vSumTraversal(root, 0, map);

    for (Map.Entry sum : map.entrySet()) {
      System.out.println(sum.getValue() + " ");
    }
  }

  private static void vSumTraversal(Node root, int hDist, TreeMap<Integer, List<Integer>> map) {

    if (root == null) return;
    vSumTraversal(root.left, hDist - 1, map);

    // Store the current node in the map at horizontal distance hd
    if (!map.containsKey(hDist)) map.put(hDist, new ArrayList<>());

    map.get(hDist).add(root.data);

    vSumTraversal(root.right, hDist + 1, map);
  }
}

class PairTraversal {
  Node node;
  int hDist;

  PairTraversal(Node n, int hd) {
    node = n;
    hDist = hd;
  }
}
