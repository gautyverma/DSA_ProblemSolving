package gfg.a5_Searching.course;

public class a13_RepeatOneElement {
  public static void main(String[] args) {
    int[] arr = {0, 2, 1, 3, 2, 2};
    System.out.println(
        "Efficient Approach 1 with O(n) time and space complexity : " + effRepeatElement1(arr));
  }

  private static int effRepeatElement1(int[] arr) {
    boolean[] boolArr = new boolean[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (boolArr[arr[i]]) {
        return arr[i];
      }
      boolArr[arr[i]] = true;
    }
    return -1;
  }
}
