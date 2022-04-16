package prac;

import java.util.ArrayList;
import java.util.List;

public class Backspacing {
	public static void main(String[] args) {
		String s1 = "yf#c#";
		String s2 = "#yy#k#pp##";
//		
//		String s1 = "abc###";
//		String s2 = "###";

		System.out.println(compare(s1, s2));
	}

	private static int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();

		char[] arr1 = s1.toCharArray();
		List<Character> list1 = new ArrayList<>();
		for (char ter : arr1) {
			list1.add(ter);
		}

		char[] arr2 = s2.toCharArray();
		List<Character> list2 = new ArrayList<>();
		for (char ter : arr2) {
			list2.add(ter);
		}

		int index = 0;
		while (index < list1.size()) {
			if (list1.get(index) == '#') {
				list1.remove(index);
				if (index >= 1) {
					list1.remove(index - 1);
				}
				if (index > 1) {
					index -= 2;
				}

			}
			index++;
		}

		index = 0;

		while (index < list2.size()) {
			if (list2.get(index) == '#') {
				list2.remove(index);
				if (index >= 1) {
					list2.remove(index - 1);
				}
				if (index > 1) {
					index -= 2;
				}
			}
			index++;
		}

		for (Character ter : list1) {
			str1.append(ter);
		}

		for (Character ter : list2) {
			str2.append(ter);
		}

		if (str1.toString().equals(str2.toString()))
			return 1;
		return 0;
	}
}
