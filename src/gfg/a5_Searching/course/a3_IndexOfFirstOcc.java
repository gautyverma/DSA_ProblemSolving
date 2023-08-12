package gfg.a5_Searching.course;
/*
 * Given a sorted array, find the first index of given item
 */

public class a3_IndexOfFirstOcc {
  public static void main(String[] args) {
    int[] arr = {1, 6, 6, 6, 7};
    System.out.println(recurFirstOcc(arr, 0, arr.length - 1, 7));
    System.out.println(itrFirstOcc(arr, 0, arr.length - 1, 7));
  }

  private static int itrFirstOcc(int[] arr, int low, int high, int item) {
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] > item) {
        high = mid - 1;
      } else if (arr[mid] < item) {
        low = mid + 1;
      } else {
        if (mid == 0 || arr[mid - 1] != arr[mid]) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  private static int recurFirstOcc(int[] arr, int low, int high, int item) {
    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (item > arr[mid]) {
      return recurFirstOcc(arr, mid + 1, high, item);
    } else if (item < arr[mid]) {
      return recurFirstOcc(arr, low, mid - 1, item);
    } else {
      if (mid == 0 || arr[mid] != arr[mid - 1]) {
        return mid;
      } else {
        return recurFirstOcc(arr, low, mid - 1, item);
      }
    }
  }
}
