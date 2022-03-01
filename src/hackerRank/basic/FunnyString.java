package hackerRank.basic;


public class FunnyString {
	public static void main(String[] args) {
		System.out.println(foo("ovyvzvptyvpvpxyztlrztsrztztqvrxtxuxq"));

	}

	private static String foo(String s) {

		char[] arr = s.toCharArray();
		int n = arr.length;
		char[] arrRev = new char[n];
		for (char c : arr) {
			arrRev[n - 1] = c;
			n--;
		}

		n = arr.length - 1;

		int[] diffArr1 = new int[n];
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			diffArr1[i] = Math.abs(arr[j] - arr[i]);
		}

		int[] diffArr2 = new int[n];
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			diffArr2[i] = Math.abs(arrRev[i] - arrRev[j]);
		}

		for (int i : diffArr2) {
			System.out.print(i+"|");
		}
		System.out.println();
		for (int i : diffArr1) {
			System.out.print(i+"|");
		}
		System.out.println();
		for(int i=0 ;i<n;i++) {
			if(diffArr1[i]!=diffArr2[i]) {
				return "Not Funny";
			}
		}
		
		return "Funny";
	}

}
