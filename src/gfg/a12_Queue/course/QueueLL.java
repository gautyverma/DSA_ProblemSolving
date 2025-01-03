package gfg.a12_Queue.course;

public class QueueLL {
  Node front, rear;
  int size;

  QueueLL() {
    front = rear = null;
    size = 0;
  }

  void enqueue(int x) {
    Node temp = new Node(x);
    size++;
    if (front == null) {
      front = temp;
      return;
    }
    rear.next = temp;
    rear = temp;
  }

  void deque() {
    if (front == null) return;
    size--;
    front = front.next;
    if (front == null) rear = null;
  }

  int getSize() {
    return size;
  }

  int getFront() {
    return front.data;
  }

  int getRear() {
    return rear.data;
  }
}

class Node {
  int data;
  Node next;

  Node(int value) {
    data = value;
    next = null;
  }
}
