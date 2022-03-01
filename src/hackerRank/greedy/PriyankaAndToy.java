package hackerRank.greedy;


import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToy {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();
	int[] arr = new int[n];
	for(int i = 0;i<n;i++) {
		arr[i] = sc.nextInt();
	}
	System.out.println(countContainer(arr));

}

private static int countContainer(int[] arr) {
	// TODO Auto-generated method stub
	Arrays.sort(arr);
	int n = arr.length;
	int i = 0,j=1,count=0;
	
	while(i<arr.length && j< arr.length) {
		if(arr[j]<=(4+arr[i])) {
			j++;
		}else {
			count++;
			i = j;
			j = i+1;
		}
	}
	return count+1;
}
}
