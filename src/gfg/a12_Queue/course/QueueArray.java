package gfg.a12_Queue.course;

public class QueueArray {
  int size, capacity;
  int[] arr;

  QueueArray(int cap) {
    capacity = cap;
    size = 0;
    arr = new int[cap];
  }

  boolean isFull() {
    return size == capacity;
  }

  boolean isEmpty() {
    return size == 0;
  }

  void enqueue(int x) {
    if (isFull()) return;
    arr[size] = x;
    size++;
  }

  void dequeue() {
    if (isEmpty()) return;
    for (int i = 0; i < size - 1; i++) {
      arr[i] = arr[i + 1];
    }
    size--;
  }

  int getFront() {
    if (isEmpty()) return -1;
    return arr[0];
  }

  int getRear() {
    if (isEmpty()) return -1;
    return arr[size - 1];
  }
}
