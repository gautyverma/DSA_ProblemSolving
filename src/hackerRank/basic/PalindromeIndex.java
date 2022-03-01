package hackerRank.basic;
public class PalindromeIndex {
	public static void main(String[] args) {
		String str1 = "bcbc";
		String str2 = "baa";
		String str3 = "aaab";
		String str4 = "bcacb";
		String str5 = "bccyb";
		System.out.println(findIndex(str1));
		System.out.println(findIndex(str2));
		System.out.println(findIndex(str3));
		System.out.println(findIndex(str5));
		System.out.println(findIndex(str4));
	}
	
	private static int findIndex(String s) {
		for(int i=0,j=s.length()-1;i<j;i++,j--) {
			if(s.charAt(i)!=s.charAt(j)) {
				return isPalindrome(s,i+1,j)?i:j;
			}
		}
		return -1;
	}

	private static boolean isPalindrome(String s, int start, int end) {
		// TODO Auto-generated method stub
		for(int i = start,j=end;i<j;i++,j--) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
				}
		}
		return true;
	}
}
