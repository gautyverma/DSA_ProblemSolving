package gfg.a2_BitMagic.course;

/*
 *  I/P - n = 5 k = 3
 *  O/P - YES
 *  
 *  binary representation - 5: 00.....0101
 *  
 *  (1<<(k-1)) -> (1<<2)  - 1: 00.....0001
 *  						After left shifit 2
 *  						-  00.....0100
 *  and of both - 00.....0101
 *  			  00.....0100
 *  			---------------
 *  			  00.....0100
 *  which is not equal to zero therefore set(1) is present at kth bit of number n.
*/
public class KthBit_isSet_Not {
	public static void main(String[] args) {
		int n = 39;
		int k = 5;
		navie(n,k);
		kthisSet_leftshift(n, k);
		kthisSet_rightshift(n, k);
	}
private static void navie(int n, int k) {
		// TODO Auto-generated method stub
	boolean flag = false;
	for(int i = 1;i<=k;i++) {
		if(n%2 != 0) {
			flag = true;
		}else
			flag = false;
		n /= 2;
	}
	if(flag)
		System.out.println("YES");
	else
		System.out.println("No");
	}
// using left shift operator
	private static void kthisSet_leftshift(int n, int k) {
		// TODO Auto-generated method stub
		System.out.println("(1 << (k - 1))"+(1 << (k - 1)));
		if ((n & (1 << (k - 1))) != 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

// using right shift operator
	private static void kthisSet_rightshift(int n, int k) {
		// TODO Auto-generated method stub
		if (((n >> (k - 1)) & 1) == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}
