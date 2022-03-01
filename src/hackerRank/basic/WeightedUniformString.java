package hackerRank.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WeightedUniformString {

	public static void main(String[] args) {
		Integer[] arr = {9,7,8,12,5};
		List<Integer> list = Arrays.asList(arr);
		System.out.println(foo("abccddde",list));
		System.out.println(foo("aaabbbbcccddd",list));
//		System.out.println(findIndex('z'));
	}

	private static List<String>  foo(String str,List<Integer> queries) {
		char[] a = str.toCharArray();
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Character, Integer> map= new HashMap<>();
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
		for(int i=0;i<a.length;i++) {
			
			int j = i;
			int count = 1;
			System.out.println("-----------i-"+i);
			System.out.println("-----------j-"+j);
			while(a[i]==a[j]) {
				System.out.println("While loop running");
				System.out.println("Value of J-------"+j);
				System.out.println("value added------>"+(count*findIndex(a[i])));
//				list.add(count*findIndex(a[i]));
				list.add(count*map.get(a[i]));
				count++;
				j++;
				
				if(j==a.length) {
					break;
				}
				
			}
			count =1;
			i = j-1;
			System.out.println("------	i=j-1	------"+i);
			System.out.println("************************");
			
		}
		System.out.println(list);
		
		List<String> res = new ArrayList<String>();
		for(int i = 0;i<queries.size();i++) {
			if(list.contains(queries.get(i))){
				res.add("Yes");
			}
			else {
				res.add("No");
			}
		}
		return res;
	}

	private static int findIndex(char c) {
		char [] charArr = {'1','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for (int i=0;i<charArr.length;i++) {
			if(c==charArr[i]) {
				return i;
			}
		}
		return 0;
	}
}
