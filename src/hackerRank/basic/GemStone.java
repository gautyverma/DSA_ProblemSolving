package hackerRank.basic;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GemStone {
public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	list.add("abc");
	list.add("abc");
	list.add("bc");
	System.out.println(fun(list));
	
}



private static int fun(List<String> list) {
	// TODO Auto-generated method stub

	Set<Character> set = convertToSet(list.get(0));
	for(int i=1;i<list.size();i++) {
		set.retainAll(convertToSet(list.get(i)));
	}
	return set.size();
}



private static Set<Character> convertToSet(String s) {
	// TODO Auto-generated method stub
	Set<Character> set = new HashSet<>();
	for (Character ch : s.toCharArray()) {
		set.add(ch);
	}
	return set;
}



private static int foo(List<String> list) {
	int minString = Integer.MAX_VALUE;
	int index = 0,count =0;
	int i = 0;
	for (String s : list) {
		if(s.length()<minString) {
			minString = s.length();
			index = i;
		}
		i++;
	}
	String str = list.get(index);
	char[] arr = str.toCharArray();
	Set<Character> set = new HashSet<Character>();
	
	for (Character c : arr) {
		set.add(c);
	}
	
	for (String s : list) {
		char[] tempArr = s.toCharArray();
		Set<Character> tempSet = new HashSet<Character>();
		for (Character ch : tempArr) {
			tempSet.add(ch);
		}
		
		if(tempSet.retainAll(set)) {
			count++;
		}
	}
	return count;
	
	
}
}
