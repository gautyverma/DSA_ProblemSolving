package hackerRank.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoStrings {

	public static Set<Character> toSetChar(char[] arr){
		Set<Character> set = new HashSet<>();
		for (char c : arr) {
			set.add(c);
		}
		return set;
	}
	
	public static String foo(String s1,String s2) {
			char[] arr1 = s1.toCharArray();
			char[] arr2 = s2.toCharArray();
			
			Set<Character> set1 = toSetChar(arr1);
			Set<Character> set2 = toSetChar(arr2);
			
			for (Character c : set2) {
				if(set1.contains(c)) {
					return "YES";
				}
			}
			return "NO";
	}
	
	public static void main(String[] args) {
		System.out.println(foo("hello", "world"));
	}

}
