package hackerRank.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosetNumber {
	public static List<Integer> fun(List<Integer> arr) {
		List<Integer> result = new ArrayList<Integer>();
		Collections.sort(arr);
		int minDiff = Integer.MAX_VALUE;

		for (int i = arr.size() - 1; i > 0; i--) {

			int j = i - 1;
//			int tempDiff = Math.abs(Math.abs(arr.get(i))-Math.abs(arr.get(j)));
			int tempDiff = arr.get(i) - arr.get(j);
			if (tempDiff <= minDiff) {
				minDiff = tempDiff;
			}
		}
		System.out.println("MinDiff----------" + minDiff);

		for(int i=0;i<arr.size()-1;i++) {
			int j = i+1;
//			int tempDiff = Math.abs(Math.abs(arr.get(i))-Math.abs(arr.get(j)));
			int tempDiff = arr.get(j)-arr.get(i);
			if(tempDiff==minDiff) {
//				System.out.println("******Second Loop********");
				result.add(arr.get(i));
				result.add(arr.get(j));
			}
		}

//		for (int i = arr.size() - 1; i > 0; i--) {
//
//			int j = i - 1;
////			int tempDiff = Math.abs(Math.abs(arr.get(i))-Math.abs(arr.get(j)));
//			int tempDiff = arr.get(i) - arr.get(j);
//			if (tempDiff == minDiff) {
//				result.add(arr.get(i));
//				result.add(arr.get(j));
//			}
//		}
//		Collections.sort(result);

		return result;
	}

	public static void main(String[] args) {
//	Integer[] arr = {2,3,4,5};
		Integer[] arr = { -20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520,
				-470 };
		List<Integer> list1 = fun(Arrays.asList(arr));
		for (Integer m : list1) {
			System.out.print(m + " ");
		}

	}
}
