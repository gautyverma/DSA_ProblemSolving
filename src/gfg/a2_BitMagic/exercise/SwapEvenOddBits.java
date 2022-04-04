package gfg.a2_BitMagic.exercise;

/*
	Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, if the given number is 23 (00010111), it should be converted to 43(00101011). Here, every even position bit is swapped with adjacent bit on the right side(even position bits are highlighted in the binary representation of 23), and every odd position bit is swapped with an adjacent on the left side.

	Example 1:
	
	Input: N = 23
	Output: 43
	Explanation:
	 
	Binary representation of the given number 
	is 00010111 after swapping 
	00101011 = 43 in decimal.

	===========================================
	
	General Appproach ->
	1. Obtain the even bits and shift these to odd positions
	2. Obtain the odd bits and shitf these to even positions
	3. Combine 1 and 2 step, w=using OR bitwise operator
	
	-----------------------------------------------------
	Example -
			x = 23 : 00010111
		
		step 1 - m = x & 0xAAAAAAAA;  // A = 1010
				 m = m >> 1;
		
		step 2 - n = x & 0x55555555;  // 5 = 0101
				 n = n << 1;
		
		step 3 - m|n
	-----------------------------------------------------	
*/

public class SwapEvenOddBits {
public static void main(String[] args) {
	int x = 23;
	System.out.println(swapEvenOddBits(x));
}

private static int swapEvenOddBits(int x) {
	// TODO Auto-generated method stub
	int m = x&0xAAAAAAAA;
	m = m>>1;
	
	int n = x&0x55555555;
	n = n<<1;
	return m|n;
}
}
