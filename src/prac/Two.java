package prac;

import java.util.Arrays;
import java.util.HashSet;

/*
	array it has {1,2,3,1,2}
	output - 1- {1,2,3}
			 2- {3} 
			 
	Str = ab;
	permuation - a,b,ab,ba
	
	1					""
	2 a-	 ""		 			"a"
	3 b- ""		"b"			"a"		"ab"
	
	----------------------------------
	
	abc -  a  - ab - abc
				ac - acb
		-  b  - ba - bac
			  - bc - bca
		-  c  - ca - cab
			  - cb - cba
	
	abc , acb , bac, bca, acb, cba
	
	
*/
public class Two {
	
	
	
	public static void main(String[] args) {
		int[] arr= {1,2,3};
		System.out.println("Output 1 - unique - "+Arrays.toString(fun1(arr)));
		System.out.println("Output 2 - " + fun2(arr));
	}

	private static int fun2(int[] arr) {
		// TODO Auto-generated method stub
		int res = 0;
		for(int i = 0;i<arr.length;i++) {
			res = res ^ i;
		}
		return res;
	}

	private static Object[] fun1(int[] arr) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<>();
		for (int ger : arr) {
			set.add(ger);
		}
		return set.toArray();
	}



}
