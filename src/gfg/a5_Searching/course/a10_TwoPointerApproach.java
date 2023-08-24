package gfg.a5_Searching.course;

/*
 * Find if any pair is present with sum x in a sorted array
 * */
public class a10_TwoPointerApproach {
  public static void main(String[] args) {
    int[] arr = {2, 5, 8, 12, 20};
    System.out.println("Naive approach : " + navFindPair(arr, 17));
    System.out.println("Efficient approach : " + effFindPair(arr, 17));
  }

  private static boolean effFindPair(int[] arr, int sum) {
    int i = 0, j = arr.length - 1;
    while (i <= j) {
      if (arr[i] + arr[j] == sum) return true;
      else if (arr[i] + arr[j] < sum) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }

  private static boolean navFindPair(int[] arr, int sum) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == sum) {
          return true;
        }
      }
    }
    return false;
  }
}
