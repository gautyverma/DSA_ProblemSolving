package hackerRank.greedy;


import java.util.*;

// Below is Java code to print
// largest permutation after
// atmost K swaps
class LargestPermutation {

	// Function to calculate largest
	// permutation after atmost K swaps
	static void KswapPermutation(
		Integer arr[], int n, int k)
	{

		// Auxiliary dictionary of storing
		// the position of elements
		int pos[] = new int[n + 1];

		for (int i = 0; i < n; ++i)
			pos[arr[i]] = i;

		for (int i = 0; i < n && k > 0; ++i) {

			// If element is already i'th
			// largest, then no need to swap
			if (arr[i] == n - i)
				continue;

			// Find position of i'th largest
			// value, n-i
			int temp = pos[n - i];

			// Swap the elements position
			pos[arr[i]] = pos[n - i];
			pos[n - i] = i;

			// Swap the ith largest value with the
			// current value at ith place
			int tmp1 = arr[temp];
			arr[temp] = arr[i];
			arr[i] = tmp1;

			// decrement number of swaps
			--k;
		}
	}
	static void KswapPermutation(
			List<Integer> arr, int n, int k)
		{
			HashMap<Integer, Integer> h  =  new HashMap<Integer, Integer>();
			for(int i = 0;i<n;i++) {
				h.put(arr.get(i), i);
			}
			if(n<=k) {
				Collections.sort((arr),Collections.reverseOrder());
			}else {
				for(int j =n;j>0;j--) {
					if(k>0) {
						int initialIndex = h.get(j);
						int bestIndex = n-j;
						if(initialIndex != bestIndex) {
							h.put(j, bestIndex);
							int element = arr.get(bestIndex);
							h.put(element,initialIndex);
							int temp  = arr.get(bestIndex);
							arr.set(bestIndex, arr.get(initialIndex));
							arr.set(initialIndex, temp);
							k--;
						}
					}
				}
			}
		}

	// Driver method
	public static void main(String[] args)
	{

		Integer arr[] = { 4, 2,3,5,1 };
		int n = arr.length;
		int k = 1;
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		Integer[] arr = new Integer[n];
//		for(int i =0 ;i<n;i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		sc.close();
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		KswapPermutation(arr, n, k);
		

		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
	}
}

