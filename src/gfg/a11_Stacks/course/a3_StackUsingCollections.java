package gfg.a11_Stacks.course;

import java.util.ArrayDeque;
import java.util.Stack;

public class a3_StackUsingCollections {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    //    ArrayDeque<Integer> stack = new ArrayDeque<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    // get and delete middle of stack
    System.out.println(stack.size());
    stack.remove(stack.size() / 2 );
    System.out.println(stack.size());

    for (Integer obj:stack){
      System.out.print(obj+" ");
    }

    System.out.println("OPS - pop out: " + stack.pop());
    System.out.println("OPS - peek: " + stack.peek());
    System.out.println("isEmpty check: " + stack.isEmpty());
    System.out.println("size of stack: " + stack.size());
  }
}
