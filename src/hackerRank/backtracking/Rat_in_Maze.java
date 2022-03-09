package hackerRank.backtracking;

public class Rat_in_Maze {
	static int n;

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		n = maze.length;

		solveMaze(maze);
	}

	private static void solveMaze(int[][] maze) {
		int sol[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sol[i][j] = 0;
			}
		}
		if (!solveMazeUtil(maze, 0, 0, sol)) {
			System.out.println("NO Solution Exists !!");
			return;
		} else {
			printSol(sol);
			return;
		}

	}

	private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
		// TODO Auto-generated method stub
		if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}
		if (isSafe(x, y, maze)) {
			if (sol[x][y] == 1) {
				return false;
			}
			sol[x][y] = 1;
			
			if(solveMazeUtil(maze, x+1, y, sol)) {
				return true;
			}
			if(solveMazeUtil(maze, x-1, y, sol)) {
				return true;
			}
			if(solveMazeUtil(maze, x, y+1, sol)) {
				return true;
			}
			if(solveMazeUtil(maze, x, y-1, sol)) {
				return true;
			}
			
			sol[x][y] = 0;
			return false;
		}

		return false;
	}

	private static boolean isSafe(int x, int y, int[][] maze) {
		// TODO Auto-generated method stub
		if (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1) {
			return true;
		}
		return false;
	}

	private static void printSol(int[][] sol) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}

	}
}
