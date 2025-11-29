package gfg.a16_Heap.course;

import gfg.a16_Heap.common.MinHeap;

public class a1_HeapOPS {
  public static void main(String[] args) {
    MinHeap h = new MinHeap(11);
    h.insertKey(3);
    h.insertKey(2);
    h.deleteKey(1);
    h.insertKey(15);
    h.insertKey(5);
    h.insertKey(4);
    h.insertKey(45);
    System.out.print(h.extractMin() + " ");
    System.out.print(h.getMin() + " ");

    h.decreaseKey(2, 1);
    System.out.print(h.getMin());
  }
}
