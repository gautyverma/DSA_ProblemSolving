package gfg.a3_Recursion.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(powerset(str));
	}

	static ArrayList<String> list = new ArrayList<>();

	private static ArrayList<String> powerset(String str) {
		// TODO Auto-generated method stub
		subsets(str, "", 0);
		//Collections.sort(list);
		//list.remove(0);
		return list;
	}

	private static void subsets(String str, String curr, int i) {
		// TODO Auto-generated method stub
		if (i == str.length()) {
			list.add(curr);
			return;

		}
		subsets(str, curr, i + 1);
		subsets(str, curr + str.charAt(i), i + 1);

	}
}
