package hackerRank.basic;


public class MinSwap {
public static void main(String[] args) {
	int[] a = {7,1,3,2,4,5,6};
	System.out.println(fun(a));
}

private static int fun(int[] arr) {
	int count=0,i=0;
	int n = arr.length;
	while(i<n) {
		if(arr[i]!=i+1) {
			int temp = arr[i];
			arr[i]=arr[temp-1];
			arr[temp-1]=temp;
			count++;
		}
		else {
			i++;
		}
	}
	// TODO Auto-generated method stub
	return count;
}
}
