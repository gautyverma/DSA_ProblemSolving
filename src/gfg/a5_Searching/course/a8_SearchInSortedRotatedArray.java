package gfg.a5_Searching.course;

public class a8_SearchInSortedRotatedArray {
  public static void main(String[] args) {

    // given a rotated sorted array - we split into two half and every time we split one half always
    // be sorted. and check if element is present in which half

    int[] arr = {10, 20, 30, 40, 50, 1, 2, 3, 4, 5, 9};
    System.out.println("Efficient Approach : " + effFindElementIndex(arr, 20));
    System.out.println("Efficient Approach : " + effFindElementIndex(arr, 2));
    System.out.println("Efficient Approach : " + effFindElementIndex(arr, 60));
  }

  private static int effFindElementIndex(int[] arr, int item) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == item) return mid;

      // left half sorted
      if (arr[low] <= arr[mid]) {
        if (item >= arr[low] && item < arr[mid]) high = mid - 1;
        else low = mid + 1;
      } // right half sorted
      else {
        if (item > arr[mid] && item <= arr[high]) low = mid + 1;
        else high = mid - 1;
      }
    }
    return -1;
  }
}
