package gfg.a11_Stacks.course;

import java.util.Stack;
// Commented case will only take care of all positive elements
public class a11_StackWithGetMin {
  Stack s;
  int min;

  int getMin() {
    return min;
  }

  int peek() {
    int t = (int) s.peek();
    //    return (t <= 0) ? min : t;
    return (t <= min) ? min : t;
  }

  int pop() {
    int t = (int) s.pop();
    if (t <= 0) {
      int res = min;
      //      min = min - t;
      min = 2 * min - t;
      return res;
    } else return t;
  }

  void push(int x) {
    if (s.isEmpty()) {
      min = x;
      s.push(x);
    } else if (x <= min) {
      //      s.push(x - min);
      s.push(2 * x - min);
      min = x;
    } else {
      s.push(x);
    }
  }
}
