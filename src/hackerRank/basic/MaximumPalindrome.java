package hackerRank.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumPalindrome {
	public static void main(String[] args) {
//		System.out.println(maxNumPalindrome("week", 2, 3));
//		System.out.println(maxNumPalindrome("madamimadam", 4, 7));
//		System.out.println(maxNumPalindrome("week", 1, 4));
		System.out.println(maxNumPalindrome("wuhmbspjnfviogqzldrcxtaeyk", 4, 5));
		
//		Scanner sc = new Scanner(System.in);
//		String next = sc.next();
//		int t = sc.nextInt();
//		for(int i=0;i<t;i++) {
//			int l = sc.nextInt();
//			int r = sc.nextInt();
//			System.out.println(maxNumPalindrome(next, l, r));
//		}
//		sc.close();
	}

	private static int maxNumPalindrome(String s, int start, int end) {
		// TODO Auto-generated method stub
		
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] arr = s.substring(start - 1, end).toCharArray();
		System.out.println(Arrays.toString(arr));
		if(arr.length==1) {
			return 1;
		}
		for (char c : arr) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int count2s = 0;
		int count1s = 0;
		for (char c : map.keySet()) {
			if (map.get(c) % 2 == 0) {
				count2s += map.get(c)/2;
			} else if(map.get(c) % 2 != 0) {
				count1s += map.get(c)/2+1;
			}
		}
		if (count1s == 0) {
			count1s = 1;
		}else if(count2s==0) {
			count2s = 1;
		}
		result = count2s * count1s;
		return result;
	}
}
