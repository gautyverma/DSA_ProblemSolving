package gfg.a2_BitMagic.course;

/*
	Given an array in which one integer is occuring odd times, find that number.
*/
public class OneOddOccuring {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7 };

		// Method-1 - Navie Approach
		System.out.println("NavieApproach -"+navieOddOccur(arr));

		// Method-2 - Efficient Approach
		System.out.println("Efficient -"+EffOddOccur(arr));
	}

	// Complexity - O(n)
	private static int EffOddOccur(int[] arr) {
		// TODO Auto-generated method stub
		int res = 0;
		for (int ger : arr) {
			res ^= ger;
		}
		return res;

	}

// Navie Approach - Two Pointer
	private static int navieOddOccur(int[] arr) {
		// TODO Auto-generated method stub
		int res=0;
		for(int i = 0;i<arr.length;i++) {
			int count = 0;
			for(int j = 0;j<arr.length;j++) {
				if(arr[j]==arr[i]) {
					count++;
				}
			}
			if(count%2 !=0) {
				res = arr[i];
				break;
			}
			
		}
		return res;
	}
}
