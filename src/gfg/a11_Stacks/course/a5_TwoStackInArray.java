package gfg.a11_Stacks.course;

public class a5_TwoStackInArray {
  public static void main(String args[]) {
    TwoStacks ts = new TwoStacks(5);
    ts.push1(5);
    ts.push1(11);
    ts.push2(40);
    ts.push2(10);
    ts.push2(15);
    System.out.println("Popped element from" + " stack1 is " + ts.pop1());
    System.out.println("Popped element from" + " stack2 is " + ts.pop2());
  }
}

class TwoStacks {
  int arr[], capacity, top1, top2;

  TwoStacks(int size) {
    capacity = size;
    arr = new int[capacity];
    top1 = -1;
    top2 = size;
  }

  boolean push1(int data) {
    if (top1 < top2 - 1) {
      top1++;
      arr[top1] = data;
      return true;
    }
    return false;
  }

  boolean push2(int data) {
    if (top1 < top2 - 1) {
      top2--;
      arr[top2] = data;
      return true;
    }
    return false;
  }

  int pop1() {
    if (top1 >= 0) {
      int res = arr[top1];
      top1--;
      return res;
    }
    return -1;
  }

  int pop2() {
    if (top2 < capacity) {
      int res = arr[top2];
      top2++;
      return res;
    }
    return -1;
  }
}
