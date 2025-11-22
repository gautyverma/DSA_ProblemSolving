package gfg.a15_BST.common;

import java.util.ArrayList;

public class OPS_BST {
  /*
  *           100
            /    \
          60     120
         /  \       \
       40   80     130
            / \
          70   90
  * */
  public Node initializeBST() {
    Node root = new Node(100);
    root.left = new Node(60);
    root.left.left = new Node(40);
    root.left.right = new Node(80);
    root.left.right.left = new Node(70);
    root.left.right.right = new Node(90);

    root.right = new Node(120);
    root.right.right = new Node(130);
    return root;
  }

  public boolean seachinBST(Node node, int key) {
    if (node == null) return false;
    else if (node.data == key) return true;
    else if (node.data < key) return seachinBST(node.right, key);
    else return seachinBST(node.left, key);
  }

  public void inorderTraversal(Node root) {
    if (root != null) {
      inorderTraversal(root.left);
      System.out.print(root.data + " ");
      inorderTraversal(root.right);
    }
  }
  private ArrayList<Integer> inOrderTraversalList(Node root){
    ArrayList<Integer> res = new ArrayList<>();
    inOrderTraversalListUtil(root,res);
    return res;
  }

  private void inOrderTraversalListUtil(Node root, ArrayList<Integer> res) {
    if(root !=null){
      inOrderTraversalListUtil(root.left,res);
      res.add(root.data);
      inOrderTraversalListUtil(root.right,res);
    }
  }

  public void preorderTraversal(Node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  public void postorderTraversal(Node root) {
    if (root != null) {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      System.out.print(root.data + " ");
    }
  }
}
