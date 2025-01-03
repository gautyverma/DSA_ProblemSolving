package gfg.a12_Queue.course;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class a1_QueueUsingCollection {
  public static void main(String[] args) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(10);
    q.add(20);
    q.add(30);
    System.out.println(q.size());
    System.out.println(q.isEmpty());
    System.out.println(q);

    // remove from first of queue
    System.out.println(q.poll());
    System.out.println(q.peek());
    System.out.println(q);

    // remove from last of queue
    System.out.println(q.remove());
    System.out.println("--- Queue with LL object ---");
    Queue<Integer> qll = new LinkedList<>();
    qll.offer(10);
    qll.offer(20);
    qll.offer(30);
    System.out.println(qll.size());
    System.out.println(qll.isEmpty());
    System.out.println(qll);
  }
}
