package gfg.a4_Array.course;

public class SubArrayWithGivenSum {
  public static void main(String[] args) {
    //
    int[] arr = {1, 4, 20, 3, 10, 5};
    int sum = 33;
    System.out.println(naiveSol(arr, sum));
    System.out.println(effSol(arr, sum));
  }

  private static boolean effSol(int[] arr, int sum) {
    System.out.println("Efficient Sol - ");
    int s = 0, curr = 0;
    for (int e = 0; e < arr.length; e++) {
      curr += arr[e];
      while (sum < curr) {
        curr -= arr[s];
        s++;
      }
      if (curr == sum) {
        return true;
      }
    }
    return false;
  }

  private static boolean naiveSol(int[] arr, int sum) {
    System.out.println("Naive Sol - ");
    for (int i = 0; i < arr.length; i++) {
      int curr = 0;
      for (int j = i; j < arr.length; j++) {
        curr += arr[j];
        if (curr == sum) {
          return true;
        } else if (curr > sum) {
          break;
        }
      }
    }
    return false;
  }
}
