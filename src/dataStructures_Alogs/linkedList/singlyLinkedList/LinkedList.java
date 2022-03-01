package dataStructures_Alogs.linkedList.singlyLinkedList;

public class LinkedList {
	public LinkedList() {
		length = 0;
	}

	ListNode head;
	private int length = 0;

	public synchronized ListNode getHead() {
		return head;
	}
	
	// lenght of list
	public  int lengthFromHead(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode !=null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	public int length() {
		return length;
	}
	//Print the list
	public void displayList() {
		ListNode temp = head;
		System.out.println("Present Linked List");
		
		while(temp != null) {
			System.out.print(temp.getData()+"-> ");
			temp = temp.getNext();
		}
	}

	// Insertions
	// 1.Inserting at the beginning
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	//2. Inserting at the end
	public synchronized void insertAtEnd(ListNode node) {
		if(head==null) {
			head = node;
		}
		else {
			ListNode last = head;
			while(last.getNext()!=null) {
				last.setNext(last.getNext());
//				last = last.getNext();
			}
			last.setNext(node);
			length++;
		}
	}
	//3. Inserting at given positions
	public void insertAtPosition(ListNode node,int position) {
		if(position<0) {
			position = 0;
		}
		if(position>length) {
			position = length;
		}
		
		// if list is empty
		if(head==null) {
			head = node;
			length++;
			return;
		}
		else if(position==0) {
			node.setNext(head);
			head = node;
		}
		else {
			ListNode temp = head;
			for(int i=1;i<position;i++) {
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		length++;
	}

}
