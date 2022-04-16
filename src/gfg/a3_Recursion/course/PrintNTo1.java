package gfg.a3_Recursion.course;

public class PrintNTo1 {
	public static void main(String[] args) {
		int n = 5;
		printNTo1(n);
	}

	private static void printNTo1(int n) {
		// TODO Auto-generated method stub
		if(n == 0) {
			return;
		}
		System.out.print(n+" ");
		printNTo1(n-1);
		
	}
}
