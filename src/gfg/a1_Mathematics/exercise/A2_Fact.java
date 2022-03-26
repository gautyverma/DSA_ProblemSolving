package gfg.a1_Mathematics.exercise;

public class A2_Fact {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fact(n));
	}

	private static int fact(int n) {
		// TODO Auto-generated method stub
		if(n <= 1) {
			return 1;
		}
		return(n*fact(n-1));
	}
}
