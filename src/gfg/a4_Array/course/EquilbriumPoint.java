package gfg.a4_Array.course;

import java.util.Arrays;

public class EquilbriumPoint {
  public static void main(String[] args) {
    //
    int[] arr = {3, 4, 8, -9, 9, 7};
    int[] arr1 = {4, 2, 2};
    System.out.println(naiveSol(arr));
    System.out.println(naiveSol(arr1));
    System.out.println(effSol(arr));
    System.out.println(effSol1(arr));
  }

  private static boolean effSol1(int[] arr) {
    System.out.println("Efficient Solution - GFG");
    int n = arr.length;
    int ls = 0, rs = 0;
    for (int i = 0; i < n; i++) {
      rs += arr[i];
    }
    for(int i = 0;i<n;i++){
      rs -= arr[i];
      if(ls == rs){
        return true;
      }
      ls += arr[i];
    }
    return false;
  }

  private static boolean effSol(int[] arr) {
    System.out.println("Efficient Solution - Mine");
    int n = arr.length;
    int[] ps = new int[n];
    ps[0] = arr[0];
    for (int i = 1; i < n; i++) {
      ps[i] = ps[i - 1] + arr[i];
    }
    System.out.println("prefix array :" + Arrays.toString(ps));
    int[] ss = new int[n];
    ss[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      ss[i] = ss[i + 1] + arr[i];
    }
    System.out.println("suffix array :" + Arrays.toString(ss));
    for (int i = 1; i < n - 1; i++) {
      if (ps[i - 1] == ss[i + 1]) {
        return true;
      }
    }

    return false;
  }

  private static boolean naiveSol(int[] arr) {
    System.out.println("Naive Solution - ");
    for (int i = 0; i < arr.length; i++) {
      int left = 0;
      int right = 0;
      for (int l = i - 1; l >= 0; l--) {
        left += arr[l];
      }
      for (int j = i + 1; j < arr.length; j++) {
        right += arr[j];
      }
      if (left == right) return true;
    }
    return false;
  }
}
