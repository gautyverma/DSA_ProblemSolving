package gfg.a12_Queue.course;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * We have taken set as [5,6]
 *  if n = 10 our O/P - 5,6,55,56,65,66,555,556,565,566
 * */
public class a4_GenNumWithSet {
  public static void main(String[] args) {
    printFirst(10);
  }

  private static void printFirst(int n) {
    Queue<String> q = new ArrayDeque<>();
    q.add("5");
    q.add("6");
    for (int count = 0; count < n; count++) {
      String curr = q.remove();
      System.out.print(curr + " ");
      q.add(curr + "5");
      q.add(curr + "6");
    }
  }
}
