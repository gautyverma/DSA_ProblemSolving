package gfg.a2_BitMagic.course;

public class CountSet_1_Bits {
	public static void main(String[] args) {
		int n = 7;
		countSetNavie(n);
		countSet_Brains(n);
		countSet_LookUp(n);
	}

// theta(1) - constant time - Best
	private static void countSet_LookUp(int n) {
		// TODO Auto-generated method stub
		int[] table = new int[256];
		table[0] = 0;
		for (int i = 1; i <= 255; i++) {
			table[i] = (i & 1) + table[i / 2];
		}

		int count = table[n & 0xff];
		n = n << 8;
		count += table[n & 0xff];
		n = n << 8;
		count += table[n & 0xff];
		n = n << 8;
		count += table[n & 0xff];

		System.out.println("Lookup-Hash Table"+count);
	}

	/*
	 * Brain's Kernigan's Algorithm
	 * 
	 * theta(number of set bits) Runs number of 1's time
	 */
	private static void countSet_Brains(int n) {
		// TODO Auto-generated method stub
		System.out.print("Brain's Algorithm - ");
		int res = 0;
		while (n > 0) {
			n = n & (n - 1);
			res++;
		}
		System.out.println(res);
	}

	/*
	 * theta(totalBits in n) 32 bits - int 64 bits - int
	 */
	private static void countSetNavie(int n) {
		// TODO Auto-generated method stub
		System.out.print("Navie Approach - ");
		int count = 0;
		while (n != 0) {

//			if(n%2!=0) {
//				count++;
//			}
//			n=n>>1;

			count += n & 1;
			n /= 2;
		}
		System.out.println(count);
	}
}
