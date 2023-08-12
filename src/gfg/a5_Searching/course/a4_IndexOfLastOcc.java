package gfg.a5_Searching.course;

/*
 * Given a sorted array, find the last index of given item
 */

public class a4_IndexOfLastOcc {
  public static void main(String[] args) {
    int[] arr = {5, 8, 8, 8, 8};
    System.out.println("Naive Solution : " + navLastOcc(arr, 8));
    System.out.println("Recursive Solution : " + recLastOcc(arr, 0, arr.length - 1, 8));
    System.out.println("Iterative Solution : " + itrLastOcc(arr, 0, arr.length - 1, 8));
  }

  private static int recLastOcc(int[] arr, int low, int high, int item) {
    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (arr[mid] < item) {
      return recLastOcc(arr, mid + 1, high, item);
    } else if (arr[mid] > item) {
      return recLastOcc(arr, low, mid - 1, item);
    } else {
      if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
        return mid;
      } else {
        return recLastOcc(arr, mid + 1, high, item);
      }
    }
  }

  private static int itrLastOcc(int[] arr, int low, int high, int item) {
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] > item) {
        high = mid - 1;
      } else if (arr[mid] < item) {
        low = mid + 1;
      } else {
        if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }

  private static int navLastOcc(int[] arr, int item) {
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] == item) {
        return i;
      }
    }
    return -1;
  }
}
