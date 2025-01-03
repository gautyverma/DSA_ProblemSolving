package gfg.a12_Queue.course;

import java.util.ArrayDeque;
import java.util.Queue;

public class a3_ReverseQueue {
  public static void main(String[] args) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(10);
    q.add(20);
    q.add(30);
    q.add(40);
    q.add(50);
    System.out.println("Original: " + q);
    reverseRecQueue(q);
    System.out.println("Reverse: " + q);
  }

  private static void reverseRecQueue(Queue<Integer> q) {
    if (q.isEmpty()) return;
    int x = q.remove();
    reverseRecQueue(q);
    q.add(x);
  }
}
