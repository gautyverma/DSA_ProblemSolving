package gfg.a5_Searching.course;

public class a5_CountOcc {
  public static void main(String[] args) {
    int[] arr = {1, 2, 7, 7, 7, 7};
    int item = 7;
    System.out.println(
        "Using two BS -> "
            + String.format("Count of Occurrence of %s : ", item)
            + countOcc(arr, item));
  }

  /*
   * Time Complexity - O(log n)
   * Space Complexity - O(1)
   */
  private static int countOcc(int[] arr, int item) {
    int first = itrFirstOcc(arr, 0, arr.length - 1, item);
    if (first == -1) {
      return 0;
    } else {
      return itrLastOcc(arr, 0, arr.length - 1, item) - first + 1;
    }
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
}
