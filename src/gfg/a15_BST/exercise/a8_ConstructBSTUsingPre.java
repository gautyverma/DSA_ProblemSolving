package gfg.a15_BST.exercise;

import gfg.a15_BST.common.Node;
import gfg.a15_BST.common.OPS_BST;

public class a8_ConstructBSTUsingPre {
    public static void main(String[] args){
        int[] pre = {40,30,35,80,100};
        OPS_BST tree = new OPS_BST();
        tree.inorderTraversal(constructBSTUsingPre(pre));
    }
    static int index = 0;

    private static Node constructBSTUsingPre(int[] pre) {
        return buildBst(pre,Integer.MAX_VALUE);
    }

    private static Node buildBst(int[] arr, int limit) {
        if(index == arr.length || arr[index] > limit)
            return null;
        Node root = new Node(arr[index++]);
        root.left = buildBst(arr,root.data);
        root.right = buildBst(arr,limit);
        return root;
    }
}
