package gfg.a6_Sorting.course;

public class a12_KthSmallestElement {
  public static void main(String[] args) {
    int[] arr = {48, 96, 12, 24, 6};
    int k = 4;
    System.out.println(k + "th smallest element - " + effKthSmallestElement(arr, k));
  }

  private static int effKthSmallestElement(int[] arr, int k) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
      int p = partition(arr, low, high);
      if (p == k - 1) {
        return arr[p];
      } else if (p > k - 1) {
        high = p - 1;
      } else {
        low = p + 1;
      }
    }
    return -1;
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high], temp = 0, i = low - 1;
    for (int j = low; j <= high - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }
}
