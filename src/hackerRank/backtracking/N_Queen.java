package hackerRank.backtracking;

public class N_Queen {
	private static int n;

	public static void main(String[] args) {
		n = 4;
		solveKt();
	}

	private static void solveKt() {
		int board[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
		if (!solveKTUtil(board, 0)) {
			System.out.println("No Solution Exists !!");
			return;
		} else {
			printBoard(board);
		}

	}

	private static boolean solveKTUtil(int[][] board, int col) {
		// TODO Auto-generated method stub
		if (col >= n) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				
				if(solveKTUtil(board, col+1))
					return true;
				
				board[i][col] = 0;
				
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		// TODO Auto-generated method stub
		// checking for row
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}

		// check upper diagonals
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}

		// check lower diagonals
		for (int i = row, j = col; i < n && j == 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	private static void printBoard(int[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}
