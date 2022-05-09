package gfg.a4_Array.course;

public class LargestElement {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 4, 5, 4, 9, 6, 7 };

		System.out.println(largestElement(arr));
	}

	public static int largestElement(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("-----Efficient Solution----------");
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
}
