package gfg.a19_BackTracking.course;

/*
*
String = "ABC"
Print all combinations but do not allow substring "AB"
* */
public class a1_StringPermutation {
  public static void main(String[] args) {

    String str = "ABC";
    char[] arr = str.toCharArray();
    permute(arr, 0);
  }

  private static void permute(char[] arr, int l) {

    // base cae
    if (l == arr.length) {
      System.out.println(new String(arr));
      return;
    }

    for (int i = l; i < arr.length; i++) {
      swap(arr, l, i);

      // check safety only for newly formed prefix
      if (isSafe(arr, l)) {
        permute(arr, l + 1);
      }
      // backTrack
      swap(arr, l, i);
    }
  }

  private static boolean isSafe(char[] arr, int l) {
    if (l > 0) {
      if (arr[l - 1] == 'A' && arr[l] == 'B') {
        return false;
      }
    }
    return true;
  }

  private static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
