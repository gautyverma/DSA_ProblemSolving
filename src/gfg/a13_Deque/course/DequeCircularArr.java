package gfg.a13_Deque.course;

/*
 * Computation to get front and rear indexes
 * deleteFront()        -> front = (front - 1) % cap;
 * insertRear(int x)    -> rear = (rear - 1) % cap;
 * insertFront(int x)   -> front = (front - 1 + cap ) % cap;
 * deleteRear()         -> rear = (rear - 1 + cap) % cap;
 * */

public class DequeCircularArr {
  int[] arr;
  int front, cap, size;

  DequeCircularArr(int capacity) {
    arr = new int[capacity];
    cap = capacity;
    front = 0;
    size = 0;
  }

  boolean isFull() {
    return size == cap;
  }

  boolean isEmpty() {
    return size == 0;
  }

  void deleteFront() {
    if (isEmpty()) return;
    front = (front + 1) % cap;
    size--;
  }

  void insertFront(int value) {
    if (isFull()) return;
    front = (front - 1 + cap) % cap;
    arr[front] = value;
    size++;
  }

  int getFront() {
    if (isEmpty()) return -1;
    else return front;
  }

  // Rear operations
  void deleteRear() {
    if (isEmpty()) return;
    size--;
  }

  void insertRear(int value) {
    if (isFull()) return;
    int rear = (front + size) % cap;
    arr[rear] = value;
    size++;
  }

  int getRear() {
    if (isEmpty()) return -1;
    else return (front - 1 + size) % cap;
  }
}
