package gfg.a2_BitMagic.exercise;

/*
	Given a number N. The task is to check whether it is sparse or not. A number is said to be a sparse number if no two or more consecutive bits are set in the binary representation.

	Example 1:
	
	Input: N = 2
	Output: 1
	Explanation: Binary Representation of 2 is 10, 
	which is not having consecutive set bits. 
	So, it is sparse number.
	Example 2:
	
	Input: N = 3
	Output: 0
	Explanation: Binary Representation of 3 is 11, 
	which is having consecutive set bits in it. 
	So, it is not a sparse number.
*/
public class NumberIsSprase {
public static void main(String[] args) {
	int n = 3;
	System.out.println(isSparse(n));
}

private static int isSparse(int n) {
	// TODO Auto-generated method stub
	while(n>0) {
		if((n&1)!=0 && (n&2)!=0) {
			return 0;
		}
		n = n>>1;
	}
	return 1;
}
}
