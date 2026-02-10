package gfg.a17_Graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class a5_KnightSteps {
  public static void main(String[] args) {
    int[] knightPos = {4, 5}, targetPos = {1, 1};
    int size = 6;
    System.out.println(
        "Min steps by knight to reach target :: " + minStep(knightPos, targetPos, size));
  }

  private static int minStep(int[] knightPos, int[] targetPos, int n) {

    // convert to 0-indexing
    int srcX = knightPos[0] - 1;
    int srcY = knightPos[1] - 1;
    int trtX = targetPos[0] - 1;
    int trtY = targetPos[1] - 1;

    if (srcX == trtX && srcY == trtY) {
      return 0;
    }
    boolean[][] visited = new boolean[n][n];
    Queue<int[]> q = new LinkedList<>();

    // Knight directions
    int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    q.offer(new int[] {srcX, srcY, 0});
    visited[srcX][srcY] = true;

    // BFS
    while (!q.isEmpty()) {
      int[] cell = q.poll();
      int x = cell[0], y = cell[1], dist = cell[2];

      for (int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
          if (nx == trtX && ny == trtY) {
            return dist + 1;
          }
          visited[nx][ny] = true;
          q.offer(new int[] {nx, ny, dist + 1});
        }
      }
    }

    return -1;
  }
}
