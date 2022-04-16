package gfg.a3_Recursion.course;

/*
	Given a rope of length n,
	Task is to cut the rope into maximum number of pieces, such that every piece of length either a,b,c.
	
	example 1 -
				I/P: n = 5    a = 2, b = 5, c = 1;
				O/p : 5 (we make 5 piece of length 1 each)

	example 2 -
				I/P: n = 23    a = 12, b = 9, c = 11;
				O/p : 2		into a and c

	example 3 -
				I/P: n = 5    a = 4, b = 2, c = 6;
				O/p : -1 	  // Not possible
*/

public class RopeCutting {
	public static void main(String[] args) {
		int n = 5;
		int a = 5, b = 1, c = 4;
		System.out.println(ropeCutting(n, a, b, c));
	}

	private static int ropeCutting(int n, int a, int b, int c) {
		// TODO Auto-generated method stub
		if (n == 0)
			return 0;
		if (n < 0)
			return -1;

		int res = Math.max(Math.max(ropeCutting(n - a, a, b, c), ropeCutting(n - b, a, b, c)),
				ropeCutting(n - c, a, b, c));
		if(res == -1) {
			return -1;
		}
		return res+1;
	}
}
