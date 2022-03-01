package InfyCodingEfficient;

import java.util.HashMap;
import java.util.Scanner;

public class A4FirstK_Occurrences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			HashMap<Character, Integer> map = new HashMap<>();
			for (char ch = 'a'; ch <= 'z'; ch++) {
				map.put(ch, k);
			}
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				if (map.get(str.charAt(j)) > 0) {
					System.out.print(str.charAt(j));
					map.put(str.charAt(j),map.get(str.charAt(j))-1);
				}
			}
		}
	}
}
