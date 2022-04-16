package gfg.a3_Recursion.course;

public class Sum_ofDigit {
public static void main(String[] args) {
	int n = 1234561;
	System.out.println("Iterative - "+iterSum(n));
	System.out.println("Recursive - "+recursiveSum(n));
}

private static int recursiveSum(int n) {
	// TODO Auto-generated method stub
	if(n==0) {
		return 0;
	}
	return (n%10)+recursiveSum(n/10);
}

private static int iterSum(int n) {
	// TODO Auto-generated method stub
	int sum = 0;
	while(n>0) {
		sum += n %10;
		n /= 10;
	}
	return sum;
}
}
