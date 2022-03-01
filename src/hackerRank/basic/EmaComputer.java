package hackerRank.basic;

import java.util.Arrays;
import java.util.List;

public class EmaComputer {
	public static void main(String[] args) {

		String[] arr = { "GGGGGG", "GBBBGB", "GGGGGG", "GGBBGB", "GGGGGG" };
		System.out.println(twoPulses(Arrays.asList(arr)));

	}

	private static int twoPulses(List<String> grid) {
		// TODO Auto-generated method stub
		int n = grid.size();
		int m = grid.get(0).length();
		int[] maxProduct = { 1, 1 };
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				int count = 1;
				if (grid.get(i).charAt(j) == 'G') {
					if (grid.get(i - 1).charAt(j) == 'G' && grid.get(i + 1).charAt(j) == 'G'
							&& grid.get(i).charAt(j - 1) == 'G' && grid.get(i).charAt(j + 1) == 'G') {
						count += 4;

					}
				}
			}

		}
		return maxProduct[0] * maxProduct[1];
	}

	private static boolean checkFurther(List<String> grid, int row, int col) {
		// TODO Auto-generated method stub
		int n = grid.size();
		int m = grid.get(0).length();
		if (row < n && row - 1 > 0 && col < m && col - 1 > 0) {
			if (grid.get(row - 1).charAt(col) == 'G' && grid.get(row + 1).charAt(col) == 'G'
					&& grid.get(row).charAt(col - 1) == 'G' && grid.get(row).charAt(col + 1) == 'G') {
//					count += 4;
				return true;

			} else {
				return false;
			}
		}
		return false;
	}
}
