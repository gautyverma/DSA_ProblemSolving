package hackerRank.basic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagram {

	public static List<Character> retriveList(char[] arr) {
		List<Character> list = new ArrayList<Character>();

		for (char c : arr) {
			list.add(c);
		}
		return list;

	}

	public static int fun(String s) {
		int n = s.length();

		if (n % 2 != 0) {
			return -1;
		}
		String s1 = s.substring(0, n / 2);
		char[] arr1 = s1.toCharArray();
		Arrays.sort(arr1);
		List<Character> list1 = retriveList(arr1);

		String s2 = s.substring(n / 2, n);
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr2);
		List<Character> list2 = retriveList(arr2);

		for (Character c : list1) {
			if (list2.contains(c)) {
				list2.remove(c);
			}
		}

		return list2.size();

	}

	public static void main(String[] args) {

		String str = "cde";
		String str1 = "abc";

		System.out.println(fun1(str, str1));
	}

	private static int fun1(String s1, String s2) {
		
		char[] arr1 = s1.toCharArray();
		List<Character> list1 = retriveList(arr1);
		char[] arr2 = s2.toCharArray();
		List<Character> list2 = retriveList(arr2);

		List<Character> list3 = new ArrayList<Character>();

		for (Character c : list1) {

			if (list2.contains(c)) {
				list2.remove(c);
				list3.add(c);
			}
		}

		for (Character c : list3) {

			if (list1.contains(c)) {
				list1.remove(c);
			}
		}

		return (list1.size() + list2.size());

	}
}

//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class Anagram {
//
//	public static List<Character> retriveList(char[] arr) {
//		List<Character> list = new ArrayList<Character>();
//
//		for (char c : arr) {
//			list.add(c);
//		}
//		return list;
//		
//	}
//
//	public static int fun(String s) {
//		int n = s.length();
//		
//
//		if (n % 2 != 0) {
//			return -1;
//		}
//		String s1 = s.substring(0, n / 2);
//		char[] arr1 = s1.toCharArray();
//		Arrays.sort(arr1);
//		List<Character> list1 = retriveList(arr1);
//		
//		
//
//		
//		String s2 = s.substring(n / 2, n);
//		char[] arr2 = s2.toCharArray();
//		Arrays.sort(arr2);
//		List<Character> list2 = retriveList(arr2);
//
//		for (Character c : list1) {
//			if(list2.contains(c)) {
//				list2.remove(c);
//			}
//		}
//
//		return list2.size();
//
//	}
//
//	public static void main(String[] args) {
//
//		String str = "hhpddlnnsjfoyxpciioigvjqzfbpllssuj";
//		String str1 = "xaxbbbxa";
//
//		System.out.println(fun(str));
//	}
//}
