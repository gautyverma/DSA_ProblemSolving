package gfg.a3_Recursion.course;

public class DecimalToBinary {
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int n = 13;
		deciToBinary(n);
		System.out.println(str);
	}

	private static void deciToBinary(int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return;
		}
		deciToBinary(n / 2);
		str.append(n % 2);
	}
}
