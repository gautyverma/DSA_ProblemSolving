package gfg.a3_Recursion.course;

import java.util.Arrays;

public class StringPermuatation {
	public static void main(String[] args) {
		String s1 = "ABCD";
		permute(s1.toCharArray(), 0);
	}

	private static void permute(char[] cs, int i) {
		// TODO Auto-generated method stub
		if (i == cs.length - 1) {
			System.out.print(String.valueOf(cs) + " | ");
			return;
		}
		char temp;
		for (int j = i; j < cs.length; j++) {

			temp = cs[j];
			cs[j] = cs[i];
			cs[i] = temp;

			permute(cs, i + 1);

			temp = cs[j];
			cs[j] = cs[i];
			cs[i] = temp;
			
		}

	}

}
