package InfyCodingEfficient;

import java.util.Scanner;


public class A8_Abbreviation {
public static void main(String[] args) {
	
//	Scanner sc = new Scanner(System.in);
//	int q = sc.nextInt();
//	for(int i = 0;i<q;i++) {
//		String str1 = sc.next();
//		String str2 = sc.next();
//		System.out.println(abbreviation(str1,str2));
//	}
//	sc.close();
	System.out.println(abbreviation1("beFgH", "EFG"));
}

static String abbreviation(String a, String b) {
    if (a.length() < b.length()) {
      return "NO";
    }

    boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if (j > i) {
          dp[i][j] = false;
        } else if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (j == 0) {
          dp[i][j] = !Character.isUpperCase(a.charAt(i - 1)) && dp[i - 1][j];
        } else if (Character.isUpperCase(a.charAt(i - 1))) {
          boolean tmp = a.charAt(i - 1) == b.charAt(j - 1) && dp[i - 1][j - 1];
          dp[i][j] = tmp;
        } else {
          boolean tmp = (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) && dp[i - 1][j - 1];
          boolean tmp2 = (tmp || dp[i - 1][j]);
          dp[i][j] = tmp2;
        }
      }
    }

    return dp[a.length()][b.length()] ? "YES" : "NO";
  }

static String abbreviation1(String a, String b) {
    boolean[][] isValid = new boolean[a.length()+1][b.length()+1];
    isValid[0][0] = true;

    for (int i= 1; i <= a.length(); i++) {
        if (Character.isUpperCase(a.charAt(i - 1))) {
            isValid[i][0] = false;
        }
        else isValid[i][0] = true;
    }
    // tabulation from start of string
    for (int i = 1; i <= a.length(); i++) {
        for (int j = 1; j <= b.length(); j++) {
            if (a.charAt(i-1) == b.charAt(j-1)) {
                isValid[i][j] = isValid[i-1][j-1];
            }else if (Character.toUpperCase(a.charAt(i-1))  ==  b.charAt(j-1)) {
                isValid[i][j] = isValid[i-1][j-1] || isValid[i-1][j];
            }else if (Character.isUpperCase(a.charAt(i-1))) {
                isValid[i][j] = false;
            }else {
                isValid[i][j] = isValid[i-1][j];
            }
        }
    }
    return isValid[a.length()][b.length()]? "YES" : "NO";


}
}
