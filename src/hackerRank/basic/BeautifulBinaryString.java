package hackerRank.basic;


public class BeautifulBinaryString {
public static void main(String[] args) {
	System.out.println(foo("0100101010"));
}

private static int foo(String s) {
	// TODO Auto-generated method stub
	int count = 0,i=0;
	s=s+"a";
	char[] arr =s.toCharArray();
	String subS = "010";
	while(i<	s.length()-3) {
		System.out.println(i);
		String tempString = s.substring(i, i+3);
		System.out.println("---------"+tempString);
		
		if(subS.equals(tempString)) {
			if(arr[i+3]==1) {
				arr[i+3]=0;
				count++;
			}
			else {
				arr[i+3]=1;
				count++;
			}
			i = i+2;
		}

			i++;
		
		
	}
	return count;
}
}
