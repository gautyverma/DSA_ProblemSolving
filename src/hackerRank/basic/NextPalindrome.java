package hackerRank.basic;
import java.util.Scanner;

public class NextPalindrome {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int num = sc.nextInt();
	if(isPalindrome(num)) {
		num++;
	}
	while(!isPalindrome(num)) {
		num += 1;
	}
	System.out.println("Next Palindrome: "+num);
}

private static boolean isPalindrome(int num) {
	// TODO Auto-generated method stub
	String str1 = String.valueOf(num);
	String str2 = (new StringBuilder(str1)).reverse().toString();
	if(str1.equals(str2)) {
		return true;
	}
	return false;
}
}
