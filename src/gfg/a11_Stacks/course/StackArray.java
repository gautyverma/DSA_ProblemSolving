package gfg.a11_Stacks.course;

public class StackArray {
  static final int MAX = 1000;
  int arr[] = new int[MAX];
  int top;

  StackArray() {
    top = -1;
  }

  boolean push(int value) {
    if (top >= (MAX - 1)) {
      System.out.println("Stack Overflow");
      return false;
    } else {
      top++;
      arr[top] = value;
//      System.out.println(value + " pushed into stack.");
      return true;
    }
  }

  int pop() {
    if (top < 0) {
      System.out.println("Stack Overflow");
      return 0;
    }
    int res = arr[top];
    top--;
    return res;
  }

  int peek() {
    if (top < 0) {
      System.out.println("Stack Overflow");
      return 0;
    }
    return arr[top];
  }

  int size() {
    return top + 1;
  }

  boolean isEmpty() {
    return (top == -1);
  }

  void print() {
    for (int i = top; i > -1; i--) {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }
}
