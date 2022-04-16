package gfg.a3_Recursion.course;

public class SubsetSum {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 3, 6 };
		int sum = 8;
		System.out.println(numSubset(arr, arr.length, sum));
	}

	private static int numSubset(int[] arr, int n, int sum) {
		// TODO Auto-generated method stub
		if (sum == 0) {
			return 1;
		}

		if (n == 0) {
			return (sum == 0) ? 1 : 0;
		}
		return numSubset(arr, n-1, sum) + numSubset(arr, n-1, sum - arr[n-1]);
	}
}
