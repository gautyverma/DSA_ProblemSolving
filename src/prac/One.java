package prac;

import java.util.Arrays;
import java.util.List;

public class One {
	public static void main(String[] args) {
//		int[] arr = { 5, 10, 15 };
//		int[] arr = { 24,11,8,3,16 };
		Integer[] arr = { 86, 89, 2, 4, 13 };
		System.out.println(fun(Arrays.asList(arr)));
	}

	private static int fun(List<Integer> arr) {
		// TODO Auto-generated method stub
		
		int count =0 ;
		for (int i = 0; i < arr.size(); i++) {
			boolean flag = true;
			for (int j = 0; j < arr.size(); j++) {
				if ((j != i)) {
					if ((arr.get(i) % arr.get(j) != 0)) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}

			}
			if (flag) {
				count++;
			}
		}
		return count;
	}
}
