package gfg.a14_Tree.exercise;

import gfg.a14_Tree.common.Node;
import gfg.a14_Tree.common.OPS_Tree;

/*
*           100
          /    \
        20      30
       /  \       \
     40   50       60
          / \
        70   80
* */

public class a15_ConvertBTToCDLL {
  public static void main(String[] args) {
    OPS_Tree tree = new OPS_Tree();
    Node root = tree.initializeTree();
    // head refers to the head of the Link List
    Node head = bTreeToCList(root);
    // Display the Circular LinkedList
    display(head);


    Node temp = new Node(1);
    temp.left = new Node(2);
    temp.left.left = new Node(4);
    temp.right = new Node(3);
    temp.right.right = new Node(5);

    head = bTreeToCList(temp);
    display(head);

    head = bTreeToCListApp2(tree.initializeTree());
    display(head);
  }

  private static Node bTreeToCListApp2(Node root) {
    if(root ==null)
      return null;
    Node node = convertBtToDLL(root);
    prev.right = node;
    node.left = prev;
    return node;
  }


  // Display Circular Link List
  public static void display(Node head) {
    System.out.println("Circular Linked List is :");
    Node itr = head;
    do {
      System.out.print(itr.data + " ");
      itr = itr.right;
    } while (itr != head);
    System.out.println();
  }

  public static Node bTreeToCList(Node root) {
    if (root == null) return null;

    // Recursively convert left and right subtrees
    Node left = bTreeToCList(root.left);
    Node right = bTreeToCList(root.right);

    // Make a circular linked list of single node
    // (or root). To do so, make the right and
    // left pointers of this node point to itself
    root.left = root.right = root;

    // Step 1 (concatenate the left list with the list
    //         with single node, i.e., current node)
    // Step 2 (concatenate the returned list with the
    //         right List)
    return concatenate(concatenate(left, root), right);
  }

  public static Node concatenate(Node leftList, Node rightList) {
    // If either of the list is empty, then
    // return the other list
    if (leftList == null) return rightList;
    if (rightList == null) return leftList;

    // Store the last Node of left List
    Node leftLast = leftList.left;

    // Store the last Node of right List
    Node rightLast = rightList.left;

    // Connect the last node of Left List
    // with the first Node of the right List
    leftLast.right = rightList;
    rightList.left = leftLast;

    // left of first node refers to
    // the last node in the list
    leftList.left = rightLast;

    // Right of last node refers to the first
    // node of the List
    rightLast.right = leftList;

    // Return the Head of the List
    return leftList;
  }
  static Node prev = null;
  private static Node convertBtToDLL(Node root) {
    if (root == null) return root;
    Node head = convertBtToDLL(root.left);

    if (prev == null) head = root;
    else {
      prev.right = root;
      root.left = prev;
    }
    prev = root;
    convertBtToDLL(root.right);
    return head;
  }
}
