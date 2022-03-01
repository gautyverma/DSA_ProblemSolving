package InfyCodingEfficient;

import java.util.Scanner;

public class A1EquilibriumIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//	int n = sc.nextInt();
//	int[] arr = new int[n];
		String nextLine = sc.nextLine();
	
		nextLine = nextLine.replace(" ", "");

		String[] split = nextLine.split(",");
		int n = split.length;
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		for (int i = 0; i < n; i++) {
			if (countSum(0, i, arr) == countSum(i + 1, n, arr)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);

	}

	private static int countSum(int start, int end, Integer[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
