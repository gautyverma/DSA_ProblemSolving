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

  static AVLNode deleteNode(AVLNode root, int key) {
    // STEP 1: PERFORM STANDARD BST DELETE
    if (root == null) return root;

    // left subtree
    if (key < root.key) root.left = deleteNode(root.left, key);

    // right subtree
    else if (key > root.key) root.right = deleteNode(root.right, key);

    // if key is same as root's key, then
    // this is the node to be deleted
    else {
      // node with only one child or no child
      if ((root.left == null) || (root.right == null)) {
        AVLNode temp = root.left != null ? root.left : root.right;

        // No child case
        if (temp == null) {
          temp = root;
          root = null;
        } else { // One child case
          root = temp;
        }
        // Copy the contents of
        // the non-empty child
      } else {
        // node with two children: Get the
        // inorder successor (smallest in
        // the right subtree)
        AVLNode temp = minValueNode(root.right);

        // Copy the inorder successor's
        // data to this node
        root.key = temp.key;

        // Delete the inorder successor
        root.right = deleteNode(root.right, temp.key);
      }
    }

    // If the tree had only one node then return
    if (root == null) return root;

    // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
    root.height = Math.max(height(root.left), height(root.right)) + 1;

    // STEP 3: GET THE BALANCE FACTOR OF THIS
    // NODE (to check whether this node
    // became unbalanced)
    int balance = getBalance(root);

    // Left-Left Case
    if (balance > 1 && key < root.left.key) return singleRotateLeft(root);

    // Right-Right Case
    if (balance < -1 && key > root.right.key) return singleRotateRight(root);

    // Left-Right Case
    if (balance > 1 && key > root.left.key) {
      return doubleRotateLR(root);
    }

    // Right-Left Case
    if (balance < -1 && key < root.right.key) {
      return doubleRotateRL(root);
    }
    return root;
  }

  // Given a non-empty binary search tree,
  // return the node with minimum key value
  // found in that tree.
  static AVLNode minValueNode(AVLNode node) {
    AVLNode current = node;

    // loop down to find the leftmost leaf
    while (current.left != null) current = current.left;

    return current;
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

    // Constructing tree given in the
    // above figure
    root = insert(root, 9);
    root = insert(root, 5);
    root = insert(root, 10);
    root = insert(root, 0);
    root = insert(root, 6);
    root = insert(root, 11);
    root = insert(root, -1);
    root = insert(root, 1);
    root = insert(root, 2);

    System.out.println("Preorder traversal of the " + "constructed AVL tree is:");
    preOrder(root);

    root = deleteNode(root, 10);

    System.out.println("\nPreorder traversal after" + " deletion of 10:");
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
