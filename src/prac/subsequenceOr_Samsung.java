package prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class subsequenceOr_Samsung {
	public static void main(String[] args) {
		int[] arr = { 10, 13, 17, 12 };
		int[] arr1 = { 1, 4, 9, 14, 15, 20, 5 };
		int[] arr2 = {3,5,1,5};
		
		fun(arr2);
		System.out.println();
		nitro(arr2);
		System.out.println();
//		System.out.println("--------------------");
//		fun(arr1);
//		System.out.println();
//		nitro(arr1);
	}

	private static void nitro(int[] arr) {
		// TODO Auto-generated method stub

		HashSet<Integer> set = new HashSet<>();

		set.add(0);

		for (int i = 0; i < arr.length; i++) {
			int orVal1 = 0;

			orVal1 |= arr[i];

			set.add(orVal1);

			int j = i + 1;

			int[] temp = new int[2];
			while (j < arr.length - 1 && arr[j] > arr[i]) {

				orVal1 |= arr[j];
				set.add(orVal1);
				if (j > 1) {
					temp[0] = arr[i];
					temp[1] = arr[j];
					set.add(temp[0] | temp[1]);
				}
				j++;
			}

			if (j < arr.length && arr[j] > arr[i]) {

				set.add(arr[j] | arr[i]);
			}

		}

		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}

	}

// create subSequence
	private static void fun(int[] arr) {
		// TODO Auto-generated method stub

		List<List<Integer>> res = new ArrayList<>();

		res.add(new ArrayList<>());
		for (int i = 0; i < arr.length; i++) {

			List<Integer> temp1 = new ArrayList<Integer>();
			temp1.add(arr[i]);

			res.add(temp1);
			int j = i + 1;

			List<Integer> temp3 = new ArrayList<Integer>();
			for (Integer ger : temp1) {
				temp3.add(ger);
			}

			while (j < arr.length - 1 && arr[j] > arr[i]) {

				temp3.add(arr[j]);
				List<Integer> temp4 = new ArrayList<Integer>();

				for (Integer ger : temp3) {
					temp4.add(ger);
				}
				res.add(temp4);

				if (temp4.size() > 2) {
					List<Integer> temp2 = new ArrayList<Integer>();

					temp2.add(temp4.get(0));
					temp2.add(temp4.get(temp4.size() - 1));

					res.add(temp2);
				}
				j++;
			}

			if (j < arr.length && arr[j] > arr[i]) {
				List<Integer> temp2 = new ArrayList<Integer>();
				temp2.add(arr[i]);
				temp2.add(arr[j]);

				res.add(temp2);
			}

		}

//		print(res);
		oreo(res);

	}

	private static void oreo(List<List<Integer>> res) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();

		for (List<Integer> list : res) {
			int result = 0;
			for (Integer ger : list) {
				result |= ger;
			}
			set.add(result);
		}

		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}

	}

	private static void print(List<List<Integer>> res) {
		// TODO Auto-generated method stub
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
