package gfg.a12_Queue.course;

public class QueueCircularArray {
  int front, size, capacity;
  int[] arr;

  QueueCircularArray(int cap) {
    capacity = cap;
    size = 0;
    front = 0;
    arr = new int[cap];
  }

  boolean isFull() {
    return size == capacity;
  }

  boolean isEmpty() {
    return size == 0;
  }

  int getFront() {
    if (isEmpty()) return -1;
    return arr[front];
  }

  int getRear() {
    if (isEmpty()) return -1;
    return arr[(front + size - 1) % capacity];
  }

  void enqueue(int x) {
    if (isFull()) return;
    int rear = getRear();
    rear = (rear + 1) % capacity;
    arr[rear] = x;
    size++;
  }

  void dequeue() {
    if (isEmpty()) return;
    front = (front + 1) % capacity;
    size--;
  }
}
