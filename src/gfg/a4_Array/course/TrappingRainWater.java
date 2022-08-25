package gfg.a4_Array.course;

import java.util.Arrays;
import java.util.Collections;

public class TrappingRainWater {
  public static void main(String[] args) {
    Integer[] arr = {3, 0, 5, 7, 2, 6};
    System.out.println("Navie Solution - " + rainWaterNavie(arr));
    System.out.println("Effective Solution - " + rainWaterEff(arr));
  }

  private static int rainWaterEff(Integer[] arr) {
    int res = 0;
    int n = arr.length;
    int[] lmax = new int[n];
    int[] rmax = new int[n];

    lmax[0] = arr[0];
    rmax[n-1] = arr[n-1];

    for(int i = 1;i<n;i++){
      lmax[i] = Math.max(arr[i],lmax[i-1]);
    }
    for(int i = n-2;i>=0;i--){
      rmax[i] = Math.max(arr[i],rmax[i+1]);
    }
    for(int i = 0;i<n;i++){
      res += Math.min(lmax[i],rmax[i]) - arr[i];
    }
  return res;
  }

  private static int rainWaterNavie(Integer[] arr) {
    // TODO Auto-generated method stub
    /*  Water cannot be stored on the corner bars so loop - 1 to n-1
        for middle bars find the max value to left of it and right of it,
        then take the min value among them.
    */
    int res = 0;
    int n = arr.length; // size of array
    for (int i = 1; i < n - 1; i++) {
      int lmax = arr[i];
      for (int j = 0; j < i; j++) {
        lmax = Math.max(lmax, arr[j]);
      }
      int rmax = arr[i];
      for (int j = i + 1; j < n; j++) {
        rmax = Math.max(rmax, arr[j]);
      }
      res += Math.min(rmax, lmax) - arr[i];
    }
    return res;
  }
}
