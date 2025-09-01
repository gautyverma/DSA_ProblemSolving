package gfg.a15_BST.course;

public class a5_AVLTree {
  // height of the tree
  static int height(AVLNode N) {
    if (N == null) return 0;
    return N.height;
  }

  // Left - Left
  static AVLNode singleRotateLeft(AVLNode X) {
    AVLNode W = X.left;
    X.left = W.right;
    W.right = X;

    X.height = 1 + Math.max(height(X.left), height(X.right));
    W.height = 1 + Math.max(height(W.left), height(W.right));
    return W;
  }

  // Right - Right
  static AVLNode singleRotateRight(AVLNode W) {
    AVLNode X = W.right;
    W.right = X.left;
    X.left = W;

    X.height = 1 + Math.max(height(X.left), height(X.right));
    W.height = 1 + Math.max(height(W.left), height(W.right));
    return X;
  }

  // Left - Right
  static AVLNode doubleRotateLR(AVLNode Z) {
    Z.left = singleRotateRight(Z.left);
    return singleRotateLeft(Z);
  }

  // Right - Left
  static AVLNode doubleRotateRL(AVLNode X) {
    X.right = singleRotateLeft(X.right);
    return singleRotateRight(X);
  }

  // Get balance factor of node N
  static int getBalance(AVLNode N) {
    if (N == null) return 0;
    return height(N.left) - height(N.right);
  }

  // Insertion
  static AVLNode insert(AVLNode node, int key) {
    // Perform the normal BST insertion
    if (node == null) return new AVLNode(key);

    if (key < node.key) node.left = insert(node.left, key);
    else if (key > node.key) node.right = insert(node.right, key);
    else // Equal keys are not allowed in BST
    return node;

    // Update height of this ancestor node
    node.height = 1 + Math.max(height(node.left), height(node.right));

    // Get the balance factor of this ancestor node
    int balance = getBalance(node);

    // If this node becomes unbalanced,
    // then there are 4 cases

    // Left-Left Case
    if (balance > 1 && key < node.left.key) return singleRotateLeft(node);

    // Right-Right Case
    if (balance < -1 && key > node.right.key) return singleRotateRight(node);

    // Left-Right Case
    if (balance > 1 && key > node.left.key) {
      return doubleRotateLR(node);
    }

    // Right-Left Case
    if (balance < -1 && key < node.right.key) {
      return doubleRotateRL(node);
    }

    // Return the (unchanged) node pointer
    return node;
  }

  // traversal of the tree
  static void preOrder(AVLNode root) {
    if (root != null) {
      System.out.print(root.key + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  // Driver code
  public static void main(String[] args) {
    AVLNode root = null;

    // Constructing tree given in the above figure
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);

    /* The constructed AVL Tree would be
              30
            /   \
          20     40
         /  \      \
       10   25     50
    */

    // Preorder traversal
    preOrder(root);
  }
}

class AVLNode {
  int key;
  AVLNode left;
  AVLNode right;
  int height;

  AVLNode(int k) {
    key = k;
    left = null;
    right = null;
    height = 1;
  }
}
