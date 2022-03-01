package InfyCodingEfficient;


import java.util.Arrays;
import java.util.Scanner;

class A3_LexiBeads {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String inputString = sc.nextLine();
			String[] inputs = inputString.split(" ");
			int k = Integer.parseInt(inputs[0]);
			String str = inputs[1];
			System.out.println(makeLexicographicalString(str, k));
		}
		sc.close();
	}

	private static String makeLexicographicalString(String str, int k) {
		if (k > 1) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			return String.valueOf(chars);
		} else {
			String combinations = str + str;
			String lMinString = str;
			for (int i = 0; i < str.length(); i++) {
				String temp = combinations.substring(i, i + str.length());
				lMinString = lMinString.compareTo(temp) < 0 ? lMinString : temp;
			}
			return lMinString;
		}
	}
}