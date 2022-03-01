package hackerRank.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Median {

	public static int fun(List<Integer> arr) {
		int n = arr.size();
		Collections.sort(arr);
		return arr.get(n/2);
	}
	
	public static void main(String[] args) {
//		Integer[] arr = {2,3,4,5};
			Integer[] arr = {0,1,2,3,4,5,6};
			int i = fun(Arrays.asList(arr));
			System.out.println(i);
	}
}
