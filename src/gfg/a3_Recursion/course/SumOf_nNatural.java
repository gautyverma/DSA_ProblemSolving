package gfg.a3_Recursion.course;

public class SumOf_nNatural {
public static void main(String[] args) {
	int n = 5;
	System.out.println("Result using formula - "+ ((n*(n+1))/2));
	System.out.println("using recurion - "+recur(n));
}

private static int recur(int n) {
	// TODO Auto-generated method stub
	if(n==0) {
		return 0 ;
	}
	return n+recur(n-1);
}
}
