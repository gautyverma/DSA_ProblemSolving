package gfg.a15_BST.course;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

import java.util.Map;
import java.util.TreeMap;

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
public class a11_VerticalSumInBT {
  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root = tree.initializeBST();
    verticalSum(root);
  }

  private static void verticalSum(Node root) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    vSumUtil(root, 0, map);

    for (Map.Entry sum : map.entrySet()) {
      System.out.print(sum.getValue() + " ");
    }
  }

  private static void vSumUtil(Node root, int hDist, TreeMap<Integer, Integer> map) {

    if (root == null) return;
    vSumUtil(root.left, hDist - 1, map);

    int sum = map.get(hDist) == null ? 0 : map.get(hDist);
    map.put(hDist, sum + root.data);

    vSumUtil(root.right, hDist + 1, map);
  }
}
