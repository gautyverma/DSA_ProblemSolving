package gfg.a4_Array.course;

/*
	maximum value of arr[j] - arr[i] such that j<i
*/public class MaximumDifference {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println(navie_maxDiff(arr));
		System.out.println(eff_maxDiff(arr));
		
	}

	private static int eff_maxDiff(int[] arr) {
		// TODO Auto-generated method stub
		int res = arr[1] - arr[0];
		int minval = arr[0];
		for(int i = 1;i<arr.length-1;i++) {
			res = Math.max(res,arr[i]-minval);
			minval = Math.min(minval, arr[i]);
		}
		return res;
	}

	private static int navie_maxDiff(int[] arr) {
		System.out.println("--navie Approach--");
		// TODO Auto-generated method stub
		int res = arr[1] - arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				res = Math.max(res,arr[j]-arr[i]);
			}
		}
		return res;
	}
	
	
}
