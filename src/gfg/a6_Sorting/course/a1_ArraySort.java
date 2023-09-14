package gfg.a6_Sorting.course;

import java.util.Arrays;
import java.util.Comparator;

public class a1_ArraySort {
  public static void main(String[] args) {
    // Primitive DataTypes
    int[] arrInt = {8, 4, 6, 4, 8, 4, 8, 6, 4, 3, 1, 4};
    Arrays.sort(arrInt);
    System.out.println(Arrays.toString(arrInt));

    char[] arrChar = {
      'a', 'g', 'u', 'a', 'k', 'q', 'L', 'G', 'F', 'U', 'L', 'A', 'S', 'G', 'L', 'F', 'I'
    };
    Arrays.sort(arrChar);
    System.out.println(Arrays.toString(arrChar));

    // Object DataTypes - Class implements Comparable Inerface
    Coodinate[] arrCoor = {
      new Coodinate(12, 33), new Coodinate(2, 23), new Coodinate(83, 39), new Coodinate(-6, 43)
    };
    Arrays.sort(arrCoor);
    for (Coodinate obj : arrCoor) {
      System.out.println(obj.x + " " + obj.y);
    }

    // Reverse sorting using comparator
    Integer[] arrInteger = {41, 8, 6, 3, 64, 34, 1, 2, 53, 24, 7, 9, 6};
    Arrays.sort(arrInteger, new MyComparator());
    System.out.println(Arrays.toString(arrInteger));
  }
}

class Coodinate implements Comparable<Coodinate> {
  int x, y;

  public Coodinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Coodinate obj) {
    return this.x - obj.x;
  }
}

class MyComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    return o2 - o1;
  }
}
