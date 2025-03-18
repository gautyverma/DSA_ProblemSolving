package gfg.a10_LinkedList.exercise.mediumHard;

import gfg.a10_LinkedList.common.Node;
import gfg.a10_LinkedList.common.OPS_LL;

import java.util.HashSet;

public class a7_IntersectionInYShapedList {
    public static void main(String[] args){
        Node head1 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);

        head1.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        Node head2 = new Node(6);
        Node n11 = new Node(7);

        head2.next = n11;
        n11.next = n2;

        OPS_LL ll = new OPS_LL();
        ll.printLL(head1);
        ll.printLL(head2);

    ll.printLL(intersectPoint(head1,head2));

    }

    private static Node intersectPoint(Node head1, Node head2) {
        HashSet set = new HashSet();
        while(head1 != null){
            if(set.contains(head1)){
                return head1;
            }
            set.add(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            if(set.contains(head2)){
                return head2;
            }
            set.add(head2);
            head2 = head2.next;
        }
        return null;
    }
}
