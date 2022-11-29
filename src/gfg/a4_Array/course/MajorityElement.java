package gfg.a4_Array.course;

public class MajorityElement {
  public static void main(String[] args) {
    //
    int[] arr = {8, 8, 6, 6, 4, 6, 6};
    System.out.println(NavieSolution(arr));
    System.out.println(EffSolution(arr));
  }

  private static int EffSolution(int[] arr) {
    System.out.println("Eff_Sol ---> ");
    // Phase - 1 find the Candidate
    int res = 0, count = 1;
    for (int i = 1; i < arr.length; i++) {

      /*      if (arr[res] == arr[i]) {
        count++;
      } else {
        count--;
      }
      */
      //      variable = Condition ? If: Else
      count = (arr[res] == arr[i]) ? count + 1 : count - 1;
      if (count == 0) {
        res = i;
        count = 1;
      }
    }
    // Phase 2 - Count for majority condition
    count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[res] == arr[i]) {
        count++;
      }
    }
    if (count > arr.length / 2) {
      System.out.println("Element : " + arr[res]);
      return res;
    }
    return -1;
  }

  private static int NavieSolution(int[] arr) {
    System.out.println("Navie_Sol ---> ");
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      int count = 0;
      for (int j = i; j < arr.length; j++) {
        if (curr == arr[j]) {
          count++;
        }
      }
      if (count > arr.length / 2) {
        System.out.println("Element : " + arr[i]);
        return i;
      }
    }
    return -1;
  }
}
