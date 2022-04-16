package gfg.a3_Recursion.exercise;

public class Sum_of_Digits_of_a_Number {
	public static void main(String[] args) {
		int num = 426;
		System.out.println(sumOfDigit(num));
	}

	private static int sumOfDigit(int num) {

		if (num == 0) {
			return 0;
		}
		
		return(num%10 + sumOfDigit(num/10));		
	}
}
