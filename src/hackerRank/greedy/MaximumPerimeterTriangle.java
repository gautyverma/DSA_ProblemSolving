package hackerRank.greedy;


import java.util.Arrays;

public class MaximumPerimeterTriangle {
	public static void main(String[] args) {
		int[] sticks = { 3, 9, 2, 15, 3 };
		int n = 5;
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] sticks = new int[n];
//		for (int i = 0; i < n; i++) {
//			sticks[i] = sc.nextInt();
//		}

		
//		i = n-3
//				while i >= 0 and (A[i] + A[i+1] <= A[i+2]) :
//				    i -= 1
//
//				if i >= 0 :
//				    print(A[i],A[i+1],A[i+2])
//				else :
//				    print(-1)
		Arrays.sort(sticks);
		int i = n-3;
		while(i>=0 &&(sticks[i]+sticks[i+1]<=sticks[i+2])) {
			i -=1;
		}
		
		if(i>=0) {
			System.out.println(sticks[i]+" "+sticks[i+1]+" "+sticks[i+2]);
		}else {
			System.out.println(-1);
		}
		
//		int max = Integer.MIN_VALUE;
//		int[] temp = new int[3];
//		Arrays.sort(sticks);
//		
//		for (int i = 0; i < sticks.length - 2; i++) {
//			for (int j = i + 1; j < sticks.length - 1; j++) {
//				for (int k = j + 1; k < sticks.length; k++) {
//					if (sticks[i] + sticks[j] > sticks[k] && sticks[i] + sticks[k] > sticks[j]
//							&& sticks[k] + sticks[j] > sticks[i]) {
//						int area = sticks[i] + sticks[j] + sticks[k];
//						if (max <= area) {
//							max = area;
//							temp[0] = sticks[i];
//							temp[1] = sticks[j];
//							temp[2] = sticks[k];
//						}
//					}
//				}
//			}
//		}
//			if (temp[0] == 0 && temp[1] == 0 && temp[2] == 0) {
//				System.out.println(0);
//			} else {
//				for (int i : temp) {
//					System.out.print(i + " ");
//				}
//			}
//		System.out.println(Arrays.toString(temp));
	}
}
