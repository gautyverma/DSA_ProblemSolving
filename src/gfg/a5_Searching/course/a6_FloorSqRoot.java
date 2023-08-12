package gfg.a5_Searching.course;

public class a6_FloorSqRoot {
  public static void main(String[] args) {
    System.out.println("Naive Solution: " + navSqRoot(10));
    System.out.println("Eff Solution: " + effSqRoot(10));
  }

  private static int effSqRoot(int item) {

    int low = 0, high = item, ans = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int msq = mid * mid;
      if (msq == item) {
        return mid;
      } else if (msq > item) {
        high = mid - 1;
      } else {
        low = mid + 1;
        ans = mid;
      }
    }
    return ans;
  }

  private static int navSqRoot(int item) {
    int i = 1;
    while (i * i <= item) {
      i++;
    }
    return i - 1;
  }
}
