package prac;

import java.util.Scanner;

public class Ridhi {
	public static void main(String[] args) {
	
		int n = 11,k=8;
		int d = 2;
		int evenNum = 0,oddNum = 0;
		if(n%2==0) {
			evenNum = n/2;
			oddNum = n/2;
		}else {
			oddNum = n/2+1;
			evenNum = n/2;
		}
		if(k<=oddNum) {
			int a = 1;
			System.out.println("Number At Kth: "+ (a+(k-1)*d));
		}else {
			int a = 2;
			k = k-oddNum;
			System.out.println("Number At Kth: "+ (a+(k-1)*d));
		}
		
	}
}
