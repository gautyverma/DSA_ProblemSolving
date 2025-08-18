package gfg.a15_BST.common;

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
}
