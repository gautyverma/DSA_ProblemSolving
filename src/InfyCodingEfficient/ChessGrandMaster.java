package InfyCodingEfficient;

import java.util.ArrayList;
import java.util.List;

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
		int xr2 = 4;

		int yl2 = 3;
		int yr2 = 4;


		if (((xr1 - xl1) + 1) * ((xr1 - xl1) + 1) > ((xr2 - xl2) + 1) * ((xr2 - xl2) + 1)) {
			possiblites(xl1, xr1, yl1, yr1, xl2, xr2, yl2, yr2);
		} else {
			possiblites(xl2, xr2, yl2, yr2, xl1, xr1, yl1, yr1);
		}

	}

	private static void possiblites(int xl1, int xr1, int yl1, int yr1, int xl2, int xr2, int yl2, int yr2) {
		// TODO Auto-generated method stub

		List<Integer> pieceList1 = new ArrayList<>();
		List<Integer> pieceList2 = new ArrayList<>();
		List<Integer[]> list1 = new ArrayList<Integer[]>();
		for (int i = xl1; i <= xr1; i++) {
			for (int j = yl1; j <= yr1; j++) {
				Integer[] temp = new Integer[2];
				temp[0] = i;
				temp[1] = j;
				list1.add(temp);
			}
		}

		List<Integer[]> list2 = new ArrayList<Integer[]>();

		for (int i = xl2; i <= xr2; i++) {
			for (int j = yl2; j <= yr2; j++) {
				Integer[] temp = new Integer[2];
				temp[0] = i;
				temp[1] = j;

				for (int k = 0; k < list1.size(); k++) {
					Integer[] ger = list1.get(k);
					if (ger[0] > temp[0] && ger[1] > temp[1]) {
						break;
					}
					if (ger[0] == temp[0] && ger[1] == temp[1]) {
						list1.remove(ger);
					}
				}
				list2.add(temp);
				pieceList2.add(findColor(i, j));
			}
		}
		
		for (Integer[] gers : list1) {
			pieceList1.add(findColor(gers[0], gers[1]));
		}
		
		int count1sl1 = 0, count0sl1 = 0, count1sl2 = 0, count0sl2 = 0;
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

		int result = (count0sl1 * count0sl2) + (count1sl1 * count1sl2);
		System.out.println(result);
	}
	

	private static int findColor(int x, int y) {
		if (x == y) {
			return 1;
		} else if (x % 2 != 0 && y % 2 != 0) {
			return 1;
		} else if (x % 2 == 0 && y % 2 == 0) {
			return 1;
		}
		return 0;
	}
}
