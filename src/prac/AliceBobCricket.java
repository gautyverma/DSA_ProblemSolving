package prac;

import java.util.Arrays;

public class AliceBobCricket {
	
	static int mod = (int)1e9+7;
	
	public static void main(String[] args) {
		int n1 = 2; // alice
		int n2 = 4; // bob

		int alice[] = { 1, 3, 5 };
		int bob[] = { 2, 4, 6 };

		int prod1 = countways(alice, alice.length, n1);
		int prod2 = countways(bob, bob.length, n2);
		System.out.println(modProd(prod1,prod2));

	}

	private static int modProd(int a, int b) {
		// TODO Auto-generated method stub
		return(a%mod * b%mod)%mod;
		
	}

	private static int countways(int[] score, int m, int runs) {
		// TODO Auto-generated method stub
		int[] table = new int[runs + 1];
		Arrays.fill(table, 0);

		table[0] = 1;

		for (int i = 0; i < m; i++) {
			for(int j = score[i];j<= runs;j++) {
				table[j] = modSum(table[j],table[j-score[i]]);
			}
		}

		return table[runs];
	}

	private static int modSum(int a,int b) {
		// TODO Auto-generated method stub
		return(a%mod + b%mod)%mod;
		
	}
}
