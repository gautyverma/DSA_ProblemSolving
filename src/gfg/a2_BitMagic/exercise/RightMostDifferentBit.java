package gfg.a2_BitMagic.exercise;

/*
	Given two numbers M and N. The task is to find the position of the rightmost different bit in the binary representation of numbers.

		Example 1: 
		
		Input: M = 11, N = 9
		Output: 2
		Explanation: Binary representation of the given 
		numbers are: 1011 and 1001, 
		2nd bit from right is different.
		Example 2:
		
		Input: M = 52, N = 4
		Output: 5
		Explanation: Binary representation of the given 
		numbers are: 110100 and 0100, 
		5th-bit from right is different.
*/
public class RightMostDifferentBit {
	public static void main(String[] args) {
		int m = 52;
		int n = 4;
		System.out.println(posOfRightMostDiffBit(m,n));
	}

	private static int posOfRightMostDiffBit(int m, int n) {
		// TODO Auto-generated method stub
		int res = 1;
		if(m==n) {
			return -1;
		}
		int xor = m^n;
		int val = 1;
		while(true) {
			if((xor & val) != 0) {
				return res;
			}
			val = val<<1;
			res++;
		}
	}
}
