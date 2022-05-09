package gfg.a4_Array.course;

public class FrequenciesSortedArray {
	public static void main(String[] args) {
		int[] arr = { 10, 10, 10, 10, 20, 20, 30, 30, 40, 50 };
		frequenciesSortedArray(arr);
		frequenciesSortedArray_gfg(arr);
	}

	private static void frequenciesSortedArray_gfg(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("--GFG--");
		int n = arr.length, freq = 1, i = 1;
		while (i < n) {
			while (i < n && arr[i] == arr[i - 1]) {

				freq++;
				i++;
			}
			System.out.println(arr[i - 1] + " - " + freq);
			i++;
			freq = 1;
		}
		if(n==1||arr[n-1]!=arr[n-2]) {
			System.out.println(arr[n - 1] + " - " + 1);
			
		}
	}

	

//----mine------
	private static void frequenciesSortedArray(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("---Gauty---");
		int temp = arr[0], count = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == temp) {
				count++;
			}
			if (arr[i + 1] != temp) {
				System.out.println(temp + "-" + count);
				temp = arr[i + 1];
				count = 0;
			}
			if (i == arr.length - 2 && arr[i + 1] == temp) {
				count++;
				System.out.println(temp + "-" + count);

			}
		}

	}
}
