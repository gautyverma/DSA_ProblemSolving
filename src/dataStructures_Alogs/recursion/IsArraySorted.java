package dataStructures_Alogs.recursion;

public class IsArraySorted {
public static void main(String[] args) {
	int [] sorted = {1,2,3,4,5,6,7,8,9};
	int [] unsorted = {8,4,3,1,9,3};
	System.out.println(isArraySorted(sorted,sorted.length));
	System.out.println(isArraySorted(unsorted,unsorted.length));
}

private static int isArraySorted(int[] arr, int n) {
	// TODO Auto-generated method stub
	if(arr.length==1||n==1) {
		return 1;
	}
	return(arr[n-1]<arr[n-2])?0:isArraySorted(arr, n-1);
}
}
