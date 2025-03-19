package gfg.a10_LinkedList.exercise.mediumHard;

import gfg.a10_LinkedList.common.NodeDoubleLL;
import gfg.a10_LinkedList.common.OPS_DLL;

public class a10_InsertInSortDLL {
    public static void main(String[] args){
        OPS_DLL dll = new OPS_DLL();
        NodeDoubleLL head = dll.initializeSortedDLL();
        dll.printDLL(sortedInsert(head,54));
    }

    private static NodeDoubleLL sortedInsert(NodeDoubleLL head, int value) {
        NodeDoubleLL node = new NodeDoubleLL(value);
        if(head == null){
            return node;
        }
        NodeDoubleLL curr = head;
        // insert at start
        if(node.data <= curr.data){
            head.prev = node;
            node.next = head;
            head = node;
            return head;
        }
        // Traverse to find the correct insertion position
        while (curr.next != null && curr.next.data < value) {
            curr = curr.next;
        }

        // Insert node after 'curr'
        node.next = curr.next;
        if (curr.next != null) {
            curr.next.prev = node;
        }
        curr.next = node;
        node.prev = curr;
        return head;
    }
}
