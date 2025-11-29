package gfg.a16_Heap.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet> {
  int val, arrPos, valuePosInArr;

  Triplet(int value, int ap, int vp) {
    val = value;
    arrPos = ap;
    valuePosInArr = vp;
  }

  @Override
  public int compareTo(Triplet o) {
    if (val <= o.val) return -1;
    else return 1;
  }
}

public class a8_MergeKSortedArray {
  public static void main(String[] args) {
    Integer[][] arr = {{10, 20, 30}, {5, 15}, {1, 9, 11, 18}};
    System.out.println(" === Naive Solution === ");
    System.out.println(Arrays.toString(mergeKSortedArr(arr)));

    System.out.println(" === Efficient Solution === ");
    System.out.println(mergeKSortedArrEff(arr));
  }

  private static ArrayList<Integer> mergeKSortedArrEff(Integer[][] arr) {
    ArrayList<Integer> res = new ArrayList<>();
    PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();

    for (int i = 0; i < arr.length; i++) {
      pq.add(new Triplet(arr[i][0], i, 0));
    }

    while (!pq.isEmpty()) {
      Triplet curr = pq.poll();
      res.add(curr.val);
      int arrPos = curr.arrPos;
      int valuePosInArr = curr.valuePosInArr;

      if (valuePosInArr + 1 < arr[arrPos].length)
        pq.add(new Triplet(arr[arrPos][valuePosInArr + 1], arrPos, valuePosInArr + 1));
    }
    return res;
  }

  private static Integer[] mergeKSortedArr(Integer[][] arr) {
    int n = arr.length;
    if (n == 0) return null;
    Integer[] list = arr[0];
    for (int i = 1; i < n; i++) {
      list = mergeTwoList(list, arr[i]);
    }
    return list;
  }

  private static Integer[] mergeTwoList(Integer[] arr1, Integer[] arr2) {
    int i = 0, j = 0, len1 = arr1.length, len2 = arr2.length;
    ArrayList<Integer> res = new ArrayList<>();
    while (i < len1 && j < len2) {
      if (arr1[i] <= arr2[j]) {
        res.add(arr1[i]);
        i++;
      } else {
        res.add(arr2[j]);
        j++;
      }
    }
    while (i < len1) {
      res.add(arr1[i]);
      i++;
    }
    while (j < len2) {
      res.add(arr2[j]);
      j++;
    }

    return res.toArray(new Integer[0]);
  }
}
