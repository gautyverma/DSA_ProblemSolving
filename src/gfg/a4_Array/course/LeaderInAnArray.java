package gfg.a4_Array.course;

public class LeaderInAnArray {
	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 10, 6, 5, 2 };
		navie_printLeader(arr);
		eff_printLeader(arr);
	}
	

	private static void eff_printLeader(int[] arr) {
		// TODO Auto-generated method stub
	
		System.out.println("\n----Efficient Approach----");
		int n = arr.length;
		// last element always included in leader group
		int curLdr = arr[n-1];
		System.out.print(curLdr+" ");
		for(int i = n-2;i>=0;i--) {
			if(curLdr < arr[i]) {
				curLdr = arr[i];
				System.out.print(curLdr+" ");
			}
		}
		
	}


	private static void navie_printLeader(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("---Navie Solution----");
		
		for(int i = 0;i<arr.length;i++) {
			boolean flag = true;
			for(int j = i+1;j<arr.length;j++) {
				if(arr[i]<=arr[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.print(arr[i]+" ");
			}
		}

	}
}
