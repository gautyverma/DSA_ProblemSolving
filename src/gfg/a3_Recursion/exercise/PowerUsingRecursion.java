package gfg.a3_Recursion.exercise;

public class PowerUsingRecursion {
	public static void main(String[] args) {
		System.out.println(RecursivePower(2, 5));
	}

	private static long RecursivePower(int base, int power) {
		// TODO Auto-generated method stub
		if(power==0) {
			return 1;
		}
		return(base*RecursivePower(base, power-1));
		
	}
}
