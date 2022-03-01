package hackerRank.basic;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringConstruction {
public static void main(String[] args) {
	System.out.println(foo("ab"));
}

private static int foo(String s) {
	// TODO Auto-generated method stub
	Set<Character> set = new HashSet<>();
	char[] arr = s.toCharArray();
	int prize = 0;
	for (char c : arr) {
		if(!set.contains(c)) {
			set.add(c);
			prize++;
		}
	}
	return prize;
}
}
