package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BeautifulSubsequence {
	public static void main(String[] args) {
		int k = 3;
		Integer[] arr = { 1,10,2,9,7 };
		System.out.println(countVal(arr, k, arr.length));
	}

	private static int countVal(Integer[] arr, int k, int length) {
		// TODO Auto-generated method stub
		int count = 0;

		List<List<Integer>> list = combinations(arr);

		for (List<Integer> ger : list) {
			if(ger.isEmpty()) {
				count++;
			}else if(ger.size() == 1) {
				count++;
			}else if(ger.size() == 2 && (ger.get(0)+ger.get(1)%k==0)){
				count++;
			}else {
				boolean flag = false;
				for(int i = 1;i<ger.size();i++) {
					if((ger.get(i)+ger.get(i-1))%k==0) {
						flag = true;
					}else {
						flag = false;
						break;
					}
				}
				if(flag) {
					count++;
				}
			}
		}
		
		return count ;

	}

	private static void printList(List<List<Integer>> list) {
		// TODO Auto-generated method stub
		for (List<Integer> ger : list) {
			for (int i = 0; i < ger.size(); i++) {
				System.out.print(ger.get(i) + " ");
			}
			System.out.println();
		}

	}

	private static List<List<Integer>> combinations(Integer[] arr) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		// add empty pair
		list.add(new ArrayList<>());

		// add single elements of array
		HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
		for (Integer ger : set) {
			List<Integer> temp = new ArrayList<>();
			temp.add(ger);
			list.add(temp);
		}

		// add sub-Arrays
		int start = 0;
		while (true) {

			if (start == arr.length) {
				break;
			}

			for (int i = start + 1; i < arr.length; i++) {
				List<Integer> temp = new ArrayList<>();
				temp.add(arr[start]);
				temp.add(arr[i]);
				list.add(temp);

				if (i - start > 1) {
					List<Integer> temp2 = new ArrayList<>();
					for (int j = start; j <= i; j++) {
						temp2.add(arr[j]);
					}
					list.add(temp2);
				}
			}

			start += 1;

		}
		return list;
	}
}
