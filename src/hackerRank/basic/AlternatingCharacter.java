package hackerRank.basic;
public class AlternatingCharacter {
public static void main(String[] args) {
	System.out.println(foo("aaaa"));
}

private static int foo(String s) {
	// TODO Auto-generated method stub
	int count = 0;
	for(int i = 0;i<s.length()-1;i++) {
		if(s.charAt(i)==s.charAt(i+1)) {
			count++;
		}
	}
	return count;
}

}
