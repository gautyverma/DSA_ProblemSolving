package gfg.a1_Mathematics.exercise;

import java.util.ArrayList;

public class A1_Roots {
	public static void main(String[] args) {
		int a = 752;
		int b = 904;
		int c = 164;
		System.out.println(sum(a, b, c));
	}

	private static ArrayList<Integer> sum(int a, int b, int c) {

		ArrayList<Integer> list = new ArrayList<>();
		double d = (b * b) - (4 * a * c);
		if (d < 0) {
			list.add(-1);
			return list;
		} else if (d == 0) {
			int res = -b / (2 * a);
			list.add(res);
			list.add(res);
			return list;
		} else {
			d = Math.sqrt(d);
			double tmp = 2*a;
			int res1 = (int)Math.floor((-(b)-d)/tmp);
			int res2 = (int)Math.floor((-(b)+d)/tmp);
			list.add(Math.max(res1, res2));
			list.add(Math.min(res1, res2));
			return list;
			
		}
	}
}
