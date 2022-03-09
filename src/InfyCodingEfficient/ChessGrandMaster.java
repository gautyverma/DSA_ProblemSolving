package InfyCodingEfficient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ChessGrandMaster {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int xl1 = 1;
		int xr1 = 2;
		int yl1 = 1;
		int yr1 = 2;

		int xl2 = 3;
		int yl2 = 3;
		int xr2 = 4;
		int yr2 = 4;

		List<Integer> pieceList1 = new ArrayList<>();
		List<Integer> pieceList2 = new ArrayList<>();

		for (int i = xl1; i <= xr1; i++) {
			for (int j = yl1; j <= yr1; j++) {
				pieceList1.add(findColor(i, j));
			}
		}
		for (int i = xl2; i <= xr2; i++) {
			for (int j = yl2; j <= yr2; j++) {
				pieceList2.add(findColor(i, j));
			}
		}
		int count1sl1 = 0, count0sl1 = 0,count1sl2 = 0, count0sl2 = 0;
		for (Integer ger : pieceList1) {
			if (ger == 1) {
				count1sl1++;
			} else {
				count0sl1++;
			}
		}
		for (Integer ger : pieceList2) {
			if (ger == 1) {
				count1sl2++;
			} else {
				count0sl2++;
			}
		}
		
		int result = (count0sl1*count0sl2)+(count1sl1*count1sl2);
		System.out.println(result);
	}

	private static int findColor(int x, int y) {
		if ((x % 2 != 0 && y % 2 != 0) || x == y) {
			return 1;
		}
		return 0;
	}
}
