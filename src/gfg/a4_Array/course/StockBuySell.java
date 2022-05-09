package gfg.a4_Array.course;

public class StockBuySell {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 3,8,12};
		stockNavie(arr);
		stockEff(arr);

	}

	private static void stockEff(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("--------Effcient-------");
		int sum = 0;
		for(int i = 1;i<arr.length;i++) {
			if(arr[i-1]<arr[i]) {
				sum += arr[i]-arr[i-1];
			}
		}
		System.out.println(sum);
		
	}

	private static void stockNavie(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("------Soni Solution ----------");
		int startVal = arr[0], endVal = arr[0], sum = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > endVal) {
				endVal = arr[i];
			} else {
				sum += endVal - startVal;
				endVal = arr[i];
				startVal = arr[i];
			}
		}
		sum += endVal - startVal;
		System.out.println(sum);

	}
}
