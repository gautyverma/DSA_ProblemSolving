package hackerRank.recursion;

import java.util.Scanner;

public class PowerSum {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int po = sc.nextInt();
	System.out.println(CSP(num,po,1,0,0)); // countSumPower(num,po,current,carry,count);
}

private static int CSP(int num, int po, int curr, int carry, int count) {
	// TODO Auto-generated method stub
	int sum = carry +(int) Math.pow(curr, po);
	if(sum == num) {
		return 1;
	}
	else if(sum > num) {
		return 0;
	}
	
	count += CSP(num,po,curr+1,sum,0);
	count += CSP(num,po,curr+1,carry,0);
	
	return count;
}
}
