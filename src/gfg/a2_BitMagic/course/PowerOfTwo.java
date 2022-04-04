package gfg.a2_BitMagic.course;

/*
 * Given Number is a power of two or not 
*/
public class PowerOfTwo {
	public static void main(String[] args) {
		int n1 = 28;
		int n2 = 64;

		// method - 1 - Navie Approach
		System.out.println("Navie - ");
		System.out.println(n1+"-"+navie(n1));
		System.out.println(n2+"-"+navie(n2));
		
		// method - 2 - Efficient Method
		System.out.println("Efficient Method - ");
		System.out.println(n1+"-"+eff(n1));
		System.out.println(n2+"-"+eff(n2));
	}

	private static boolean eff(int n) {
		// TODO Auto-generated method stub
		if(n==0)
			return false;
		return((n&(n-1))==0);
	}

	// method - 1 - Navie Approach
	private static boolean navie(int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return false;
		}
		while (n != 1) {
			if (n % 2 != 0) {
				return false;
			}
			n /= 2;
		}
		return true;
	}

}
