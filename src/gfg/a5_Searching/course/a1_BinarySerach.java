package gfg.a5_Searching.course;

public class a1_BinarySerach {
  public static void main(String[] args) {
    int[] arr = {10, 20, 30, 40, 50, 60};
    System.out.println(navieBinarySearch(arr, 20));
    System.out.println(effBinarySearch(arr, 400));
  }
  /*
  Steps -
      compute mid = floor((low+high)/2)
      case 1: arr[mid] == item -> return mid
      case 2: arr[mid] > item  -> high = mid - 1
      case 3: arr[mid] < item  -> low = mid +1
   */
  private static int effBinarySearch(int[] arr, int item) {
    int i = 0, j = arr.length, mid;
    while (i < j) {
      mid = (i + j) / 2;
      if (arr[mid] == item) {
        return mid;
      }
      if (arr[mid] > item) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }
    return -1;
  }

  private static int navieBinarySearch(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        return i;
      }
    }
    return -1;
  }
}
