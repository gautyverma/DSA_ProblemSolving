package gfg.a6_Sorting.course;

public class a9_InversionOfArray {
  public static void main(String[] args) {
    int[] arr = {40, 30, 20, 10};
    System.out.println("Naive Approach: " + navInversion(arr));
    System.out.println("Eff Approach: " + effInversion(arr));
  }

  private static int effInversion(int[] arr) {
    return countInv(arr, 0, arr.length - 1);
  }

  private static int countInv(int[] arr, int l, int r) {
    int res = 0;
    if (r > l) {
      int m = l + (r - l) / 2;
      res += countInv(arr, l, m);
      res += countInv(arr, m + 1, r);
      res += countedMege(arr, l, m, r);
    }
    return res;
  }

  private static int countedMege(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1, n2 = r - m;
    int[] left = new int[n1], right = new int[n2];
    for (int i = 0; i < n1; i++) {
      left[i] = arr[l + i];
    }
    for (int i = 0; i < n2; i++) {
      right[i] = arr[m + i + 1];
    }

    int res = 0, i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      if (left[i] < right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
        res = res + (n1 - i);
      }
      k++;
    }
    while (i < n1) {
      arr[k] = left[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = right[j];
      j++;
      k++;
    }
    return res;
  }

  private static int navInversion(int[] arr) {
    int res = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          res++;
        }
      }
    }
    return res;
  }
}
