package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

import java.util.ArrayList;

public class a18_SerializeDeserializeBT {
  static int EMPTY = -1;
  static int index = 0;

  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTreeUsingInsertion();
    ArrayList<Integer> serializeList = new ArrayList<>();

    serializeBT(root, serializeList);
    System.out.println(serializeList);

    Node curr = deserializeBT(serializeList);
    tree.preorderTraversal(curr);

    System.out.println();
    tree.preorderTraversal(root);
  }

  private static Node deserializeBT(ArrayList<Integer> arr) {
    if (index == arr.size()) return null;
    int val = arr.get(index);
    index++;
    if (val == EMPTY) {
      return null;
    }
    Node root = new Node(val);
    root.left = deserializeBT(arr);
    root.right = deserializeBT(arr);
    return root;
  }

  private static void serializeBT(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      arr.add(EMPTY);
      return;
    }
    arr.add(root.key);
    serializeBT(root.left, arr);
    serializeBT(root.right, arr);
  }
}
