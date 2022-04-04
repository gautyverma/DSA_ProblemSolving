package gfg.a2_BitMagic.exercise;

/*
	You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.

	Example 1:
	
	Input: A = 10, B = 20
	Output: 4
	Explanation:
	A  = 01010
	B  = 10100
	As we can see, the bits of A that need 
	to be flipped are 01010. If we flip 
	these bits, we get 10100, which is B.
*/
public class BitDifference {
	public static void main(String[] args) {
		int a = 10, b = 20;
		System.out.println(countBitsFlip(a, b));
	}

	private static int countBitsFlip(int a, int b) {
		// TODO Auto-generated method stub
		int res = 0;
		int xor = a^b;
		while(xor>0) {
			xor = xor & (xor-1);
			res++;
		}
		return res;
	}
}
