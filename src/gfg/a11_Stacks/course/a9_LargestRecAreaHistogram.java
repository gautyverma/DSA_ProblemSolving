package gfg.a11_Stacks.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class a9_LargestRecAreaHistogram {
  public static void main(String[] args) {
    int[] arr = {6, 2, 5, 4, 1, 5, 6};
    System.out.println("1.Naive method: " + getMaxArea(arr));
    System.out.println("2.Better method: " + getMaxArea2(arr));
    System.out.println("3.Efficient method: " + getMaxArea3(arr));
  }

  private static int getMaxArea3(int[] arr) {
    Stack s = new Stack();
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!s.isEmpty() && arr[(int) s.peek()] >= arr[i]) {
        int tp = (int) s.pop();
        int curr = arr[tp] * (!s.isEmpty() ? (i - 1 - (int) s.peek()) : i);
        res = Math.max(res, curr);
      }
      s.push(i);
    }
    while (!s.isEmpty()) {
      int tp = (int) s.pop();
      int curr = arr[tp] * (s.isEmpty() ? arr.length : arr.length - 1 - (int) s.peek());
      res = Math.max(res, curr);
    }
    return res;
  }

  private static int getMaxArea2(int[] arr) {
    int res = 0;
    ArrayList<Integer> ps = findPreviousSmallerElementIndexArr(arr);
    //    System.out.println(ps);
    ArrayList<Integer> ns = findNextSmallerElementIndexArr(arr);
    //    System.out.println(ns);
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      // value from ps
      curr += (i - ps.get(i) - 1) * arr[i];
      // value from ns
      curr += (ns.get(i) - i - 1) * arr[i];
      res = Math.max(res, curr);
    }
    return res;
  }

  private static ArrayList<Integer> findNextSmallerElementIndexArr(int[] arr) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    s.push(arr.length - 1);
    list.add(arr.length);
    for (int i = arr.length - 2; i >= 0; i--) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
      list.add(s.isEmpty() ? arr.length : s.peek());
      s.push(i);
    }
    Collections.reverse(list);
    return list;
  }

  private static ArrayList<Integer> findPreviousSmallerElementIndexArr(int[] arr) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    s.push(0);
    list.add(-1);
    for (int i = 1; i < arr.length; i++) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
      list.add(s.isEmpty() ? -1 : s.peek());
      s.push(i);
    }
    return list;
  }

  private static int getMaxArea(int[] arr) {
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] >= arr[i]) curr += arr[i];
        else break;
      }
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] >= arr[i]) curr += arr[i];
        else break;
      }
      res = Math.max(res, curr);
    }
    return res;
  }
}
