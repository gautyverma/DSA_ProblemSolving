package gfg.a3_Recursion.exercise;

public class PowerNumReverse {
	public static void main(String[] args) {
		int n = 39907139;
		int r = 93170993;
		System.out.println(power(n, r));
	}

	static int m=1000000007; 
	static long c(int n,int r){

	       long result=power(n,r/2);
	            result=(result*result)%m;
	               if(r%2==0){
	                    return result;
	                     }
	                     else{
	                         return  n*result;
	                           }
	       
	                       }
	 static long power(int n,int r){
	      if(r==0){
	      return 1;
	      
	        }

	          return c(n,r)%m;
	        }
}
