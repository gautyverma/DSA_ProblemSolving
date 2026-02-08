package gfg.a7_Matrix.exercise;

public class a4_DeterminantMatrix {
  public static void main(String[] args) {
    int n = 4;
    int arr[][] = {{1, 0, 2, -1}, {3, 0, 0, 5}, {2, 1, 4, -3}, {1, 0, 5, 0}};
    System.out.println("Determinant of matrix :: " + determinantMatrix(arr, n));
  }

  /*
  1. If n == 1
        return mat[0][0]

  2. If n == 2
        return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0])

  3. Initialize det = 0
  4. Initialize sign = 1

  5. For col = 0 to n-1
        a. Create a sub-matrix temp of size (n-1) x (n-1)
        b. Fill temp by excluding row 0 and column col from mat
        c. det = det + (sign * mat[0][col] * Determinant(temp, n-1))
        d. sign = -sign   // change sign for next column

  6. Return det
  * */
  private static int determinantMatrix(int[][] arr, int n) {
    if (n == 1) return arr[0][0];
    if (n == 2) return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];

    int det = 0;
    int sign = 1;

    for (int col = 0; col < n; col++) {
      int[][] subMat = new int[n - 1][n - 1];
      int row = 0;
      for (int i = 1; i < n; i++) {
        int column = 0;
        for (int j = 0; j < n; j++) {
          if (j == col) continue;
          subMat[row][column++] = arr[i][j];
        }
        row++;
      }
      det += sign * arr[0][col] * determinantMatrix(subMat, n - 1);
      sign = -sign;
    }
    return det;
  }
}
