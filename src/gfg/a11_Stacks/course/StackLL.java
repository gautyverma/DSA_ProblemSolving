package gfg.a11_Stacks.course;

public class StackLL {

  Node head;
  int size;

  StackLL() {
    head = null;
    size = 0;
  }

  void push(int data) {
    Node temp = new Node(data);
    temp.next = head;
    head = temp;
    size++;
  }

  int pop() {
    if (isEmpty()) return Integer.MAX_VALUE;
    int res = head.data;
    head = head.next;
    size--;
    return res;
  }

  int peek() {
    if (isEmpty()) return Integer.MAX_VALUE;
    return head.data;
  }

  int size() {
    return size;
  }

  boolean isEmpty() {
    return head == null;
  }

  public void print() {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();
  }
}
