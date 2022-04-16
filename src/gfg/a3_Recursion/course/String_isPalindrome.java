package gfg.a3_Recursion.course;

public class String_isPalindrome {
	public static void main(String[] args) {
		String str = "abcba";
		System.out.println("Iterative solution - " + isPalindrome_Iter(str));
		System.out.println("Recursive solution - " + isPalindrome_Recursive(str, 0, str.length() - 1));
	}

	private static boolean isPalindrome_Recursive(String str, int start, int end) {
		// TODO Auto-generated method stub
//		int n = end - start;
//		if (n == 1 || n == 0) {
//			return true;
//		}
//		if (str.charAt(start) == str.charAt(end)) {
//			isPalindrome_Recursive(str, start + 1, end - 1);
//		} else {
//			return false;
//		}
//		return true;

		if(start>=end) {
			return true;
		}
		return (str.charAt(start)==str.charAt(end)&&isPalindrome_Recursive(str, start+1, end-1));
	}

	private static boolean isPalindrome_Iter(String str) {
		// TODO Auto-generated method stub
		StringBuilder s1 = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			s1.appendCodePoint(str.charAt(i));
		}
		if (!s1.toString().equals(str))
			return false;
		return true;
	}
}
