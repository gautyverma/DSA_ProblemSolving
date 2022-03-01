package hackerRank.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
	int[] arr = { 300, 400, 600, 700 ,400};
		
		Arrays.sort(arr);
		List<Integer> list1 = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			list1.add(arr[i]);
		}
		
	}
}
