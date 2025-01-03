package gfg.a12_Queue.course;

import java.util.Queue;

public class a2_StackUsingQueue {
  Queue<Integer> q1, q2;

  int top() {
    return q1.peek();
  }

  int size() {
    return q1.size();
  }

  int pop() {
    return q1.poll();
  }

  void push(int x) {
    while (!q1.isEmpty()) {
      q2.add(q1.poll());
    }
    q1.add(x);
    while (!q2.isEmpty()) {
      q1.add(q2.poll());
    }
  }
}
