package gfg.a5_Searching.course;

/*
 * Given a sorted and x, Find if triplet is present whose sum is x.
 * */
public class a11_TripletInSortedArr {
  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 8, 9, 20, 40};
    System.out.println("Efficient Approach: " + effIsTriplet(arr, 89));
  }

  private static boolean effIsTriplet(int[] arr, int x) {
    for (int k = 0; k < arr.length - 2; k++) {
      int i = k + 1, j = arr.length - 1;
      while (i < j) {
        if (arr[k] + arr[i] + arr[j] == x) {
          return true;
        } else if (arr[k] + arr[i] + arr[j] > x) {
          j = j - 1;
        } else {
          i = i + 1;
        }
      }
    }
    return false;
  }
}
