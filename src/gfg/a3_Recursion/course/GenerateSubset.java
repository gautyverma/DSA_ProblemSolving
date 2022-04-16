package gfg.a3_Recursion.course;

/*
	1->	I/p : s = "AB"  all are distinct value
		O/P : " ","A","B","AB"
		
	2->	I/p : s = "ABC"  all are distinct value
		O/P : " ","C","B","BC","A","AC","AB","ABC";
		
		recursive tree - left of every node presents not include the value
		
							  			"" 								----> curr and index = 0
							/ 						\
					   		""				 		  "A" 				----> index = 1
					  /  		\				/   	 	\
					""  		"B" 	  		"A"   		"AB" 		----> index = 2
				  / 	 \	 /  	\		 /     \  	 /   	 \
				""		"C" "B"		"BC"	"A"	   "AC" "AB"	"ABC"	----> index = 3
*/	
public class GenerateSubset {
	public static void main(String[] args) {
		String str = "ABC";
		generateSubsets(str, "", 0);
	}

	private static void generateSubsets(String str, String curr, int index) {
		// TODO Auto-generated method stub
		if (index == str.length()) {
			System.out.print(curr+" ");
			return;
		}
		
		//Not Include
		generateSubsets(str, curr, index+1);
		// Include
		generateSubsets(str, curr+str.charAt(index), index+1);
	}
}
