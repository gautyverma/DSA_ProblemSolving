package gfg.a15_BST.exercise;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

import java.util.ArrayList;

/*
*
* You are given the root of two BSTs, you have to merge this two BST and return the in-order traversal of the new BST.
*
*           BST - 1
              100
            /    \
          60     120
         /  \       \
       40   80     130
            / \
          70   90
    ------------------------
*        BST - 2
*          110
          /    \
        60     120
       /  \       \
     50   90     130
          /
        70
* */
public class a4_MergeTwoBST {

  public static void main(String[] args) {
    OPS_BST tree = new OPS_BST();
    Node root1 = tree.initializeBST();
    Node root2 = tree.initializeBST1();
    System.out.println(merge(root1, root2));
  }

  private static ArrayList<Integer> merge(Node root1, Node root2) {

    return mergeList(inOrderTraversalList(root1), inOrderTraversalList(root2));
  }

  private static ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
    int i = 0, j = 0;
    ArrayList<Integer> res = new ArrayList<>();
    while (i < list1.size() && j < list2.size()) {
      if (list1.get(i).equals(list2.get(j)) || list1.get(i) < list2.get(j)) {
        res.add(list1.get(i));
        i++;
      } else if (list1.get(i) > list2.get(j)) {
        res.add(list2.get(j));
        j++;
      }
    }

    while (i < list1.size()) {
      res.add(list1.get(i));
      i++;
    }
    while (j < list2.size()) {
      res.add(list2.get(j));
      j++;
    }
    return res;
  }

  private static ArrayList<Integer> inOrderTraversalList(Node root) {
    ArrayList<Integer> res = new ArrayList<>();
    inOrderTraversalListUtil(root, res);
    return res;
  }

  private static void inOrderTraversalListUtil(Node root, ArrayList<Integer> res) {
    if (root != null) {
      inOrderTraversalListUtil(root.left, res);
      res.add(root.data);
      inOrderTraversalListUtil(root.right, res);
    }
  }
}
