package gfg.a5_Searching.course;
/*
 * Peak Element -> element which has left and right element lesser
 * arr[] = [10,20,15,5,23,90,60]
 * o/p = 20 or 90
 * */
public class a9_PeakElement {
  public static void main(String[] args) {
    int arr[] = {10, 20, 15, 5, 23, 90, 67};
    System.out.println("Naive approach = " + navFindPeakElement(arr));
    System.out.println("Efficient approach = " + effFindPeakElement(arr));
  }

  private static int effFindPeakElement(int[] arr) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if ((mid == 0 || arr[mid - 1] <= arr[mid])
          && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) return arr[mid];
      if (mid > 0 && arr[mid - 1] >= arr[mid]) high = mid - 1;
      else low = mid + 1;
    }
    return -1;
  }

  private static int navFindPeakElement(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0];
    if (arr[0] >= arr[1]) return arr[0];
    if (arr[n - 1] >= arr[n - 2]) return arr[n - 1];
    for (int i = 1; i < n - 1; i++) {
      if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) return arr[i];
    }
    return -1;
  }
}
