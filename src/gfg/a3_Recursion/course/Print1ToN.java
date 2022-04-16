package gfg.a3_Recursion.course;

public class Print1ToN {
	public static void main(String[] args) {
		int n = 5;
		print1ToN(n);
	}

	private static void print1ToN(int n) {
		// TODO Auto-generated method stub
		
		/*
		 * Tail Recursive
		 * 
		 * if (a > n) { return; }
		 *  System.out.print(a + " "); 
		 *  print1ToN(n, a + 1);
		 * 
		 */		if (n == 0) {
			return;
		}
		print1ToN(n - 1);
		System.out.print(n + " ");

	}
}
