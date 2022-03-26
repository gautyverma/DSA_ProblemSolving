package gfg.a1_Mathematics.exercise;

public class A4_GP_n {
	public static void main(String[] args) {
		System.out.println(termOfGP(84,87,3));
		
	}
	
	private static double termOfGP(int A,int B,int N)
    {
        //Your code here
        return A*Math.pow((double)B/A,N-1);
    }

}
