package gfg.a5_Searching.course;
/*
 * Given an infinite sorted arr find the element
 * */
public class a7_FindElementInInfiniteArr {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 200, 300};
    System.out.println("Naive Solution : " + navEleSearch(arr, 7));
    System.out.println("Efficient Solution : " + effEleSearch(arr, 70));
  }

  private static int effEleSearch(int[] arr, int item) {
    if (arr[0] == item) {
      return 0;
    }
    int i = 1;
    // check i<> arr.length is for impl in java only
    while (arr[i] < item) {
      i = i * 2;
      if (i > arr.length) {
        break;
      }
    }
    if (i < arr.length && arr[i] == item) return i;
    return BS(arr, i / 2 + 1, i - 1, item);
  }

  private static int BS(int[] arr, int low, int high, int item) {
    while (low <= high) {
      int mid = (low + high) / 2;

      if (arr[mid] > item) {
        high = mid - 1;
      } else if (arr[mid] == item) {
        return mid;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  private static int navEleSearch(int[] arr, int item) {
    int i = 0;
    while (true) {
      if (arr[i] == item) return i;
      if (arr[i] > item) return -1;
      i++;
    }
  }
}
