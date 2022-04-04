package gfg.a2_BitMagic.exercise;

public class FindFirstSetBit {
	public static void main(String[] args) {
		int n = 12;
		// method1 - navie
		System.out.println(navie(n));
	}

	private static int navie(int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			return 0;
		}
		int res = 1;
		int val = 1;
		while (true) {
			if ((n & val) == val) {
				return res;
			}
			val = val << 1;
			res++;
		}
	}
}
