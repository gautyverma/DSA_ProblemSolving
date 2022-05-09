package gfg.a4_Array.course;

public class SecondLargest {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 1, 3, 8, 40, 68, 6, 2 };
		System.out.println("Index of 2nd largest number : " + navie_SecondLargest(arr));
		System.out.println("---------------------------------------------------------");
		System.out.println("Index of 2nd largest number : " + eff_SecondLargest(arr));
	}

	// efficient approach
	private static int eff_SecondLargest(int[] arr) {
		System.out.println("------Efficient Approach------");
		// index of 2nd largest and largest
		int res = -1, largest = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[largest]) {
				res = largest;
				largest = i;
			}
			else if(arr[i]!=arr[largest]) {
				if(res == -1 || arr[i]>arr[res]) {
					res = i;
				}
			}
		}
		return res;
	}

	// navie method
	private static int navie_SecondLargest(int[] arr) {
		System.out.println("----Navie Solution----");
		int res = -1;

		// finding the largest element
		int largest = LargestElement.largestElement(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != largest) {
				if (res == -1) {
					res = i;
				} else if (arr[i] > arr[res]) {
					res = i;
				}
			}
		}
		if (res != -1)
			System.out.println("SecondLargest : " + arr[res]);
		return res;
	}

}
