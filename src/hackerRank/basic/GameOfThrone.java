package hackerRank.basic;


public class GameOfThrone {
public static void main(String[] args) {
	System.out.println(foo("aaabbb"));
}

private static String foo(String s) {
	// TODO Auto-generated method stub
	String a ="abcdefghijklmnoqrstuvwxyz";
	int oddCount = 0,evenCount=0;
	for(int i=0;i<a.length();i++) {
		int c=0;
		for(int j=0;j<s.length();j++) {
			
			if(a.charAt(i)==s.charAt(j)) {
				c++;
			}
		}
		if(c%2==0) {
			evenCount++;
		}
		else {
			oddCount++;
		}
	}
	
	if(oddCount<=1)
		return "YES";
	else if(oddCount==2 && s.length()%2==0) {
		return "YES";
	}
	else {
		return "NO";
	}
}
}
