package hackerRank.backtracking;

import java.util.Arrays;
import java.util.Iterator;

public class KnightsTour {
	public static void main(String[] args) {
		solveKT();
	}

	private static int n = 8; // grid size

	private static void solveKT() {
		// TODO Auto-generated method stub
		int[][] sol = new int[n][n];

		// initialize to -1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sol[i][j] = -1;
			}
		}

		// Moves of knight
		int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

		sol[0][0] = 0;
		if (!solveUtilKT(0, 0, 1, sol, xMove, yMove)) {
			System.out.println("No Solution Exists !!");
			return;
		} else {
			printSol(sol);
			return;
		}
	}

	private static boolean isSafe(int[][] sol, int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n && sol[x][y] == -1) {
			return true;
		}
		return false;
	}

	private static boolean solveUtilKT(int x, int y, int movei, int[][] sol, int[] xMove, int[] yMove) {
		// TODO Auto-generated method stub
		int k, nextX, nextY;
		if (movei == n * n) {
			return true;
		}
		for (k = 0; k < 8; k++) {
			nextX = x + xMove[k];
			nextY = y + yMove[k];
			if (isSafe(sol, nextX, nextY)) {
				sol[nextX][nextY] = movei;
				if (solveUtilKT(nextX, nextY, movei + 1, sol, xMove, yMove)) {
					return true;
				} else {
					sol[nextX][nextY] = -1; // Backtracking
				}
			}
		}
		return false;
	}

	private static void printSol(int[][] sol) {
		
//		System.out.println(Arrays.deepToString(sol));
		for(int i =0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
}
