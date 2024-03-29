package gfg.a5_Searching.course;
/*
Time Complexity - O(log n)
Space Complexity - O(log n)
*/
public class a2_RecursiveBinarySearch {
  public static void main(String[] args) {
    int[] arr = {10, 20, 30, 40, 50, 60};
    System.out.println(RecursiveBinarySearch(arr, 0, arr.length - 1, 10));
  }

  private static int RecursiveBinarySearch(int[] arr, int low, int high, int item) {

    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (arr[mid] == item) {
      return mid;
    } else if (arr[mid] < item) {
      return RecursiveBinarySearch(arr, mid + 1, high, item);
    } else {
      return RecursiveBinarySearch(arr, low, mid - 1, item);
    }
  }
}
