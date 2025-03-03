package gfg.a13_Deque.course;

// Java implementation of De-queue using circular array

class MyDeque {
  private int[] arr;
  private int front, size, capacity;

  // Constructor to initialize the deque with a given
  // capacity
  public MyDeque(int c) {
    arr = new int[c];
    capacity = c;
    size = 0;
    front = 0;
  }

  // Delete element from the front
  public int deleteFront() {
    // Empty deque
    if (size == 0) return -1;
    int res = arr[front];

    // Move front index circularly
    front = (front + 1) % capacity;
    size--;
    return res;
  }

  // Insert element at the front
  public void insertFront(int x) {
    // Full deque
    if (size == capacity) return;

    // Move front index circularly
    front = (front - 1 + capacity) % capacity;
    arr[front] = x;
    size++;
  }

  // Insert element at the rear
  public void insertRear(int x) {
    // Full deque
    if (size == capacity) return;

    // Calculate rear index
    int rear = (front + size) % capacity;
    arr[rear] = x;
    size++;
  }

  // Delete element from the rear
  public int deleteRear() {
    // Empty deque
    if (size == 0) return -1;

    // Calculate rear index
    int rear = (front + size - 1) % capacity;
    size--;
    return arr[rear];
  }

  // Get the front element
  public int frontEle() {
    return arr[front];
  }

  // Get the rear element
  public int rearEle() {
    // Calculate rear index
    int rear = (front + size - 1) % capacity;
    return arr[rear];
  }
}

public class a1_DequeCircularArr {
  public static void main(String[] args) {
    // Create deque with capacity 4
    MyDeque dq = new MyDeque(4);

    // Insert at rear
    dq.insertRear(10);
    System.out.println("Front:" + dq.frontEle() + " Rear:" + dq.rearEle());

    // Insert at front
    dq.insertFront(20);
    System.out.println("Front:" + dq.frontEle() + " Rear:" + dq.rearEle());
    dq.insertFront(30);
    System.out.println("Front:" + dq.frontEle() + " Rear:" + dq.rearEle());

    // Delete from rear
    dq.deleteRear();
    System.out.println("Front:" + dq.frontEle() + " Rear:" + dq.rearEle());
    dq.insertRear(40);
    System.out.println("Front:" + dq.frontEle() + " Rear:" + dq.rearEle());
    dq.deleteRear();
    System.out.println("Front:" + dq.frontEle() + " Rear:" + dq.rearEle());
  }
}
