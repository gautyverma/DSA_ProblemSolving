package gfg.a19_BackTracking.exercise;

public class a3_LargestNumInKSwaps {
  public static void main(String[] args) {
    String str = "4682699";
    int k = 2;
    System.out.println("Largest Num after k-swap :: " + findMaxNum(str, k));
  }

  static String maxString;

  private static String findMaxNum(String str, int k) {
    maxString = str;
    char[] arr = str.toCharArray();
    solve(arr, k, 0);
    return maxString;
  }

  private static void solve(char[] arr, int k, int index) {

    // base case
    if (k == 0 || index == arr.length - 1) return;
    char maxDigit = arr[index];

    // Find maxDigit in remaining string
    for (int i = index + 1; i < arr.length; i++) {
      if (arr[i] > maxDigit) {
        maxDigit = arr[i];
      }
    }

    if (maxDigit != arr[index]) {
      k--;
    }
    for(int i = arr.length - 1 ; i>=0;i--){
      if(arr[i] == maxDigit){
        swap(arr,index,i);
        String curr = new String(arr);
        if(curr.compareTo(maxString) > 0){
          maxString = curr;
        }
        solve(arr,k,index+1);
        swap(arr,index,i);
      }
    }
  }
  private static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
