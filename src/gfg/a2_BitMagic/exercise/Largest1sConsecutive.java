package gfg.a2_BitMagic.exercise;

/*
	Given a number N. Find the length of the longest consecutive 1s in its binary representation.

	Example 1:
	
	Input: N = 14
	Output: 3
	Explanation: 
	Binary representation of 14 is 
	1110, in which 111 is the longest 
	consecutive set bits of length is 3.
*/
public class Largest1sConsecutive {
	public static void main(String[] args) {
		int n = 14;
		System.out.println(count1sCon(n));
	}

	private static int count1sCon(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		int maxCount = 0;
		boolean flag = true;
		for(int i = 0;i< 32;i++) {
			if((n&(1<<i))!=0) {
				flag = true;
				count++;
				if(count>maxCount) {
					maxCount = count;
				}
			}else {
				flag = false;
				count = 0;
			}
		}
		return maxCount;
	}
}
