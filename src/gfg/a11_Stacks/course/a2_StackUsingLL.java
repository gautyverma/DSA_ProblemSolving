package gfg.a11_Stacks.course;

public class a2_StackUsingLL {
  public static void main(String[] args) {
    StackLL stack = new StackLL();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.print();
    System.out.println("OPS - pop out: " + stack.pop());
    stack.print();
    System.out.println("OPS - peek: " + stack.peek());
    System.out.println("isEmpty check: " + stack.isEmpty());
    System.out.println("size of stack: " + stack.size());
    stack.print();
  }
}



