package hackerRank.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CeaserCipher2 {
public static void main(String[] args) {
	System.out.println(foo("www.abc.xy",87));
}

private static String foo(String s, int k) {
	k = k%26;
	Map<Character, Integer> map= new HashMap();
	map.put('a', 1);
	map.put('b', 2);
	map.put('c', 3);
	map.put('d', 4);
	map.put('e', 5);
	map.put('f', 6);
	map.put('g', 7);
	map.put('h', 8);
	map.put('i', 9);
	map.put('j', 10);
	map.put('k', 11);
	map.put('l', 12);
	map.put('m', 13);
	map.put('n', 14);
	map.put('o', 15);
	map.put('p', 16);
	map.put('q', 17);
	map.put('r', 18);
	map.put('s', 19);
	map.put('t', 20);
	map.put('u', 21);
	map.put('v', 22);
	map.put('w', 23);
	map.put('x', 24);
	map.put('y', 25);
	map.put('z', 26);
	List<Character> list = new ArrayList<>();
	StringBuilder str = new StringBuilder();
	char[] arr = s.toCharArray();
	for (char c : arr) {
		
		if(Character.isUpperCase(c)) {
			char ch = Character.toLowerCase(c);
			int value = map.get(ch)+k;
			
			if(value>26) {
				value = value-map.get(ch);
			}
			
			ch = getKey(map,value);
			ch = Character.toUpperCase(ch);
			str.append(ch);
		}
		else if(Character.isLowerCase(c)) {
			
			int value = map.get(c)+k;
			System.out.println("----value----"+value);
			if(value>26) {
				value = value-26;
			}
			c = getKey(map,value);
			str.append(c);
		}
		else {
			str.append(c);
		}
	}
	return str.toString();
}

private static char getKey(Map<Character, Integer> map, Integer value) {
	for (Character k : map.keySet()) {
		if(value.equals(map.get(k))) {
			return k;
		}
	}
	return 0;
}
}
