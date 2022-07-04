package hackerRank.basic;

import java.util.ArrayList;
import java.util.List;

public class TwoCharacters {
public static void main(String[] args) {
	System.out.println(foo("beabeefeab"));
}

private static int foo(String s) {
	char[] arrS = s.toCharArray();
	List<Character> list = new ArrayList<>();
	
	for (Character c : arrS) {
		if(!list.contains(c)) {
			list.add(c);
		}
	}
	List<Integer> value = new  ArrayList<Integer>();
	
	for(int i=0;i<list.size();i++) {
		List<Character> list2 = new ArrayList<Character>();
		List<Character> tempList = list;
		for(int j =0;j<list.size();j++) {
			
			char one = list.get(i);
			char two = list.get(j);
			
			for (Character c : tempList) {
				if(c==one||c==two) {
					list2.add(c);
				}
			}
			
		}
	}
	return 0;
	
	
}
}
