package hackerRank.greedy;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyFlorist {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	Integer[] arr = new Integer[n];
	for(int i = 0;i<n;i++ ) {
		arr[i] = sc.nextInt();
	}
	
	int price = 0, prev = 0;
	Arrays.sort(arr,Collections.reverseOrder());
	for(int i=0, j = k-1;i<n;i++) {
		price += arr[i]*(prev+1);
		if(i==j) {
			prev++;
			j += k;
		}
	}
	System.out.println(price);
}
}
