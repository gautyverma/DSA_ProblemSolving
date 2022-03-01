package InfyCodingEfficient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A5KingdomSafety {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
//		int[] arr = { 300, 400, 600, 700 };
		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
		int t = 1;
		for (int j = 0; j < t; j++) {
//			int n = sc.nextInt();
//			int[] arr = new int[n];
			int[] arr = { 300, 400,500,600, 700,800 };
			int n = arr.length;
//			for (int k = 0; k < n; k++) {
//				arr[k] = sc.nextInt();
//			}

			System.out.println(minCost(arr,n));
			
			/*
			 * Arrays.sort(arr); List<Integer> list1 = new ArrayList<>();
			 * 
			 * for (int i = 0; i < arr.length; i++) { list1.add(arr[i]); } int[] vehicle =
			 * new int[2]; int cost = 0, minList2 = Integer.MAX_VALUE;
			 * 
			 * List<Integer> list2 = new ArrayList<>(); int index = 0; while
			 * (!list1.isEmpty()) { vehicle[0] = list1.get(index); list1.remove(index);
			 * 
			 * vehicle[1] = list1.get(index); list1.remove(index);
			 * 
			 * int max = Math.max(vehicle[0], vehicle[1]); cost += max;
			 * 
			 * list2.add(vehicle[0]); list2.add(vehicle[1]);
			 * 
			 * Integer min = Collections.min(list2); Collections.sort(list2);
			 * list2.remove(0);
			 * 
			 * if (!list1.isEmpty()) { cost += min; list1.add(min); } }
			 * System.out.println(cost);
			 */ }
	}

	private static long minCost(int[] arr, int n) {
		// TODO Auto-generated method stub
		long cost = 0;
		Arrays.sort(arr);
		
		for(int i = n-1;i>1;i-=2) {
			if(i == 2) {
				cost += arr[2] + arr[0];
			}else {
				long p1 = arr[i] + arr[i-1]+2*arr[0];
				long p2 = 2*arr[1] + arr[0] + arr[i];
				cost += Math.min(p1, p2);
			}
		}
		
		if(n == 1) {
			return arr[0];
		}else {
			cost += arr[1];
		}
		return cost;
		
	}
}
