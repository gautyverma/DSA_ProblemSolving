package gfg.a17_Graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a matrix mat[][], where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cell have fresh oranges
2 : Cell have rotten oranges
* */
public class a4_RottenOranges {
  public static void main(String[] args) {
    int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println("minimum time to make oranges rotten :: " + orangesRot(arr));
  }

  private static int orangesRot(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;
    Queue<int[]> q = new LinkedList<>();
    int freshCount = 0;

    // Step 1: Add all rotten oranges & count fresh ones
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 2) {
          q.offer(new int[] {i, j});
        } else if (mat[i][j] == 1) {
          freshCount++;
        }
      }
    }
    int time = 0;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // 2. BFS
    while (!q.isEmpty() && freshCount > 0) {
      int size = q.size(); // one level = one minute
      time++;
      for (int s = 0; s < size; s++) {
        int[] cell = q.poll();
        int x = cell[0], y = cell[1];
        // d -> directions
        for (int d = 0; d < 4; d++) {
          int nx = x + dx[d];
          int ny = y + dy[d];

          if (nx >= 0 && ny >= 0 && nx < row && ny < col && mat[nx][ny] == 1) {
            mat[nx][ny] = 2;
            freshCount--;
            q.offer(new int[] {nx, ny});
          }
        }
      }
    }
    // Step 3: Check if all oranges are rotten
    return freshCount == 0 ? time : -1;
  }
}
