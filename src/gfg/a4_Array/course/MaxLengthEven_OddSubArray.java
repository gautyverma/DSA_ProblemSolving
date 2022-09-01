package gfg.a4_Array.course;

/*
    Find Max subarray length which have alternative even odd or vice versa values.
*/
public class MaxLengthEven_OddSubArray {
  public static void main(String[] args) {
    //
    int[] arr = {7,13,11};
    System.out.println("Mine Solution: " + maxLengthEvenOddSubArray(arr));
  }

  private static int maxLengthEvenOddSubArray(int[] arr) {
    int count = 1, res = 1;
    char prev = isEven(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      char curr = isEven(arr[i]);
      if (prev != curr) {
        count++;
      } else {
        count = 1;
      }
      res = Math.max(count, res);
      prev = curr;
    }
    return res;
  }

  private static char isEven(int i) {
    if (i % 2 == 0) {
      return 'e';
    }
    return 'o';
  }
}
