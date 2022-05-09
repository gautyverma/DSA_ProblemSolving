package gfg.a4_Array.course;

import java.util.Arrays;
import java.util.Collections;

public class TrappingRainWater {
	public static void main(String[] args) {
		Integer[] arr = { 1,2,3};
		rainWater(arr);
	}

	private static void rainWater(Integer[] arr) {
		// TODO Auto-generated method stub
		int res = 0;int sum=0;
		int start = arr[0];
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]>start) {
				start=arr[i];
				res+=sum;sum=0;
			}
			else {
				sum+=start-arr[i];
			}
		}
		System.out.println(res);
		Collections.reverse(Arrays.asList(arr));
		res = 0;sum=0;
		start = arr[0];
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]>start) {
				start=arr[i];
				res+=sum;sum=0;
			}
			else {
				sum+=start-arr[i];
			}
		}
		System.out.println(res);
		
	}
}
