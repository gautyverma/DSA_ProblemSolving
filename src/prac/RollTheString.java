package prac;

import java.util.HashMap;
import java.util.Map;

public class RollTheString {
	public static void main(String[] args) {
		String s = "abz";
		int[] roll = {  3 };
		System.out.println(rolling(roll, s));
	}

	private static String rolling(int[] roll, String s) {

		// TODO Auto-generated method stub
		Map<Integer, Character> map = new HashMap<Integer, Character>();

		map.put(1, 'a');
		map.put(2, 'b');
		map.put(3, 'c');
		map.put(4, 'd');
		map.put(5, 'e');
		map.put(6, 'f');
		map.put(7, 'g');
		map.put(8, 'h');
		map.put(9, 'i');
		map.put(10, 'j');
		map.put(11, 'k');
		map.put(12, 'l');
		map.put(13, 'm');
		map.put(14, 'n');
		map.put(15, 'o');
		map.put(16, 'p');
		map.put(17, 'q');
		map.put(18, 'r');
		map.put(19, 's');
		map.put(20, 't');
		map.put(21, 'u');
		map.put(22, 'v');
		map.put(23, 'w');
		map.put(24, 'x');
		map.put(25, 'y');
		map.put(26, 'z');

		Map<Character, Integer> reverMap = new HashMap<Character, Integer>();
		reverMap.put('a', 1);
		reverMap.put('b', 2);
		reverMap.put('c', 3);
		reverMap.put('d', 4);
		reverMap.put('e', 5);
		reverMap.put('f', 6);
		reverMap.put('g', 7);
		reverMap.put('h', 8);
		reverMap.put('i', 9);
		reverMap.put('j', 10);
		reverMap.put('k', 11);
		reverMap.put('l', 12);
		reverMap.put('m', 13);
		reverMap.put('n', 14);
		reverMap.put('o', 15);
		reverMap.put('p', 16);
		reverMap.put('q', 17);
		reverMap.put('r', 18);
		reverMap.put('s', 19);
		reverMap.put('t', 20);
		reverMap.put('u', 21);
		reverMap.put('v', 22);
		reverMap.put('w', 23);
		reverMap.put('x', 24);
		reverMap.put('y', 25);
		reverMap.put('z', 26);

		char[] arr = s.toCharArray();

		for (int i = 0; i < roll.length; i++) {
			for (int j = 0; j < roll[i]; j++) {
				int n = reverMap.get(arr[j]) + 1;
				if (n > 26) {
					n %= 26;
				}
				arr[j] = map.get(n);

			}
//			System.out.println(String.valueOf(arr));
		}

		return String.valueOf(arr);
	}
}
