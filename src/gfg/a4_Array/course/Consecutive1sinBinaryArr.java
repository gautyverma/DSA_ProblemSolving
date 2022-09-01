package gfg.a4_Array.course;

public class Consecutive1sinBinaryArr {
  public static void main(String[] args) {
        int[] arr = {1,1,1,1};
//    int[] arr = {0, 0};
    System.out.println("Max Consecutive 1's 'Navie': " + countCon1sNavie(arr));
    System.out.println("Max Consecutive 1's \"Effect\": " + countCon1sEff(arr));
  }

  private static int countCon1sEff(int[] arr) {
    int res = 0, curr = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        curr = 0;
      } else {
        curr++;
        res = Math.max(curr,res);
      }
    }
    return res;
  }

  private static int countCon1sNavie(int[] arr) {
    System.out.println("---- Navie Approach -----");
    int maxCount = 0, i = 0;
    while (i < arr.length) {
      int count = 0;
      if (arr[i] == 1) {
        int j = i;
        while (j < arr.length && arr[j] == 1) {
          count++;
          j++;
          i = j;
        }
      }
      i++;
      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }
}
