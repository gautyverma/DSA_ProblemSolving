package hackerRank.basic;

public class SeparateTheNumber{
	public static void main(String[] args) {
		System.out.println(foo("909192"));
	}

	private static String foo(String s) {
		// TODO Auto-generated method stub
		long firstx=-1;
		boolean flag = false;
		
		for(int i=1;i<s.length()/2;++i) {
			long x = Long.parseLong(s.substring(0, i));
			firstx = x;
			String test = Long.toString(x);
			while(test.length()<s.length()) {
				test += Long.toString(++x);
			}
			if(test.equals(s)) {
				flag = true;
				break;
			}
		}
		return (flag?"YES "+firstx:"NO");
	}
}

//import java.util.Scanner;
//
//public class SeparateTheNumber {
//	public static void main(String[] args) {
////		Scanner in = new Scanner(System.in);
////		int q = in.nextInt();
////		for(int a0 = 0; a0 < q; a0++) {
////			String s = in.next();
//			String s = "99100";
//			boolean valid = false;
//			long firstx = -1;
//			// Try each possible starting number
//			for (int i=1; i<=s.length()/2; ++i) {
////				System.out.println(i);
//				long x = Long.parseLong(s.substring(0,i));
//				System.out.println("----Substrig---"+x);
//				System.out.println("*************************");
//				firstx = x;
//			   // Build up sequence starting with this number
//				String test = Long.toString(x);
//				while (test.length() < s.length()) {
//					System.out.println(x);
//					test += Long.toString(++x);
//					System.out.println("=---test---="+test);
//				}
//				// Compare to original
//				if (test.equals(s)) {
//					valid = true;
//					break;
//				}
//			}
//			System.out.println(valid ? "YES " + firstx : "NO");
////		}
//	}
//}
