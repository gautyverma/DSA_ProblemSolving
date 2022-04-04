package gfg.a2_BitMagic.course;

/*
	Given a String find all possible pairs.
	example - 
	1. "abc"- "","a","b","c","ab","bc","ac","abc" - total = 8
	2. "ab" - "","a","b","ab" - total = 4
*/
public class PowerSet {
public static void main(String[] args) {
	String str = "abc";
	printPowerSet(str);
}

private static void printPowerSet(String str) {
	// TODO Auto-generated method stub
	int n = str.length();
	int powerSize = (int) Math.pow(2, n);
	for(int counter = 0 ;counter<powerSize;counter++) {
		for(int i = 0;i<n;i++) {
			if((counter&(1<<i))!=0) {
				System.out.print(str.charAt(i)+" ");
			}
		}
		System.out.println();
	}
}
}
