package InfyCodingEfficient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class A9_GoodString {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int t = sc.nextInt();
	for(int i = 0;i<t;i++) {
		String str = sc.next();

		System.out.println(goodString1(str));
	}
}


private static String goodString1(String str) {
	char[] arr = str.toCharArray();
	StringBuilder sb = new StringBuilder();
	
	List<Character> list = new ArrayList<Character>();
	for (char ch : arr) {
		list.add(ch);
	}
	sb.append(list.get(0));
	for(int i = 1;i<list.size();i++) {
		if(list.get(i)!=list.get(i-1)) {
			sb.append(list.get(i));
		}
	}
	return sb.toString();
	
}

}
