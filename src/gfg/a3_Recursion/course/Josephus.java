package gfg.a3_Recursion.course;

public class Josephus {
	public static void main(String[] args) {
		int n = 14, k = 2;
		System.out.println(jos(n, k));
	}

	private static int jos(int n, int k) {
		// TODO Auto-generated method stub
		if (n == 1)
			return 1;
		return (jos(n - 1, k) + k - 1) % n + 1;
	}
}
