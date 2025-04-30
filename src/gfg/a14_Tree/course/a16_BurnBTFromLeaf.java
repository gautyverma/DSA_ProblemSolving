package gfg.a14_Tree.course;

import gfg.a14_Tree.common.Node;

class Distance {
  int val;

  Distance(int d) {
    val = d;
  }
}

/*
              1
            /   \
          2       3
         / \     /
        4   5   6
       /   / \
      8   9  10
         /
        11
*/
public class a16_BurnBTFromLeaf {
  public static void main(String args[]) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.left.left.left = new Node(8);
    root.left.right.left = new Node(9);
    root.left.right.right = new Node(10);
    root.left.right.left.left = new Node(11);
    Distance dist = new Distance(-1);
    int target = 11;

    burnTime(root, target, dist);
    System.out.print(res);
  }

  static int res = 0;

  // Function to find the time to burn
  public static int burnTime(Node root, int leaf, Distance dist) {
    if (root == null) return 0;
    int key = root.key;
    if (root.key == leaf) {
      dist.val = 0;
      return 1;
    }
    Distance ldist = new Distance(-1), rdist = new Distance(-1);
    int lh = burnTime(root.left, leaf, ldist);
    int rh = burnTime(root.right, leaf, rdist);

    if (ldist.val != -1) {
      dist.val = ldist.val + 1;
      res = Math.max(res, dist.val + rh);
    } else if (rdist.val != -1) {
      dist.val = rdist.val + 1;
      res = Math.max(res, dist.val + lh);
    }
    return Math.max(lh, rh) + 1;
  }
}

/*
* burnTime(1, 11, dist)
  → Calls burnTime(2, 11, ldist)
    → Calls burnTime(4, 11, ldist)
      → Calls burnTime(8, 11, ldist)
        → leaf not found, returns height 1
      → Calls burnTime(null), returns 0
      ← burnTime(4) returns height 2
    → Calls burnTime(5, 11, rdist)
      → Calls burnTime(9, 11, ldist)
        → Calls burnTime(11, 11, ldist)
          → MATCH FOUND: dist.val = 0, return 1
        → burnTime(null), return 0
        ← burnTime(9): dist.val = 1, height = 2
        → Updates res = max(0, 1 + 0) = 1
      → Calls burnTime(10, 11, rdist)
        → burnTime(null), return 0
        → burnTime(null), return 0
        ← burnTime(10): height = 1
      ← burnTime(5): dist.val = 2, res = max(1, 2 + 1) = 3
    ← burnTime(2): dist.val = 3, res = max(3, 3 + 2) = 5
  → Calls burnTime(3, 11, rdist)
    → Calls burnTime(6, 11, ldist) → return 1
    → burnTime(null) → return 0
    ← burnTime(3): height = 2
← burnTime(1): dist.val = 4, res = max(5, 4 + 2) = 6

* */
