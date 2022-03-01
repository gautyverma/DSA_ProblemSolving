package dataStructures_Alogs.linkedList.singlyLinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegin(new ListNode(4));
		ll.insertAtEnd(new ListNode(9));
		ll.insertAtPosition(new ListNode(10), 1);
		ll.displayList();
	}
}
