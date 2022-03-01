package hackerRank.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MarcsCakeWalk {
	public static void main(String[] args) {
//		Integer[] arr = {1,3,2};
		Integer[] arr = {819, 701, 578, 403, 50, 400, 983, 665,
						510, 523, 696, 532, 51, 449, 333, 234, 
						958, 460, 277, 347, 950, 53, 123, 227, 
						646, 190, 938, 61, 409, 110, 61, 178, 659, 
						989, 625, 237, 944, 550, 954, 439};
		
		long i = marcsCakewalk(Arrays.asList(arr));
		System.out.println(i);
	}

	private static long marcsCakewalk(List<Integer> calorie) {
		// TODO Auto-generated method stub
		Collections.sort(calorie);
		Collections.reverse(calorie);
		long result = 0 ;
		for(int i=0;i<calorie.size();i++) {
			result += pow(i)*calorie.get(i);
		}
		
		return result;
	}
	
	private static long pow(int power) {
		long res = 1;
		for(int i=0;i<power;i++) {
			res = res*2;
		}
		return res;
	}
}
