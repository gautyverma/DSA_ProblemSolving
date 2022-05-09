package gfg.a4_Array.course;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
public static void main(String[] args) {
	int[] arr = {10,20,20,30,30,30,40};
	
	navie_RemoveDuplicate(arr);
//	System.out.println("Array : "+Arrays.toString(res)+"\n"+"size : "+res.length);
}

private static void navie_RemoveDuplicate(int[] arr) {
	// TODO Auto-generated method stub
	int[] temp = new int[arr.length];
	temp[0] = arr[0];
	int res = 1;
	
	for(int i =1;i<arr.length;i++) {
		if(arr[i]!=arr[res-1]) {
			temp[res] = arr[i];
			res++;
		}
	}
	for(int i =0 ;i<res;i++) {
		arr[i] = temp[i];
	}
	System.out.println(Arrays.toString(temp));
	System.out.println("Size : "+res);
}
}
