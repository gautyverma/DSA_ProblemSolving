package gfg.a4_Array.course;

public class IsArraySorted {
public static void main(String[] args) {
	int[] arr = {10,20,30,50,60};
	System.out.println(navie_isArraySorted(arr));
	System.out.println("----------------");
	System.out.println(eff_isArraySorted(arr));
}

private static boolean eff_isArraySorted(int[] arr) {
	// TODO Auto-generated method stub
	System.out.println("----Efficient Approach----");
	for(int i = 1;i<arr.length;i++) {
		if(arr[i]<arr[i-1]) {
			return false;
		}
	}
	return true;
}

private static boolean navie_isArraySorted(int[] arr) {
	// TODO Auto-generated method stub
	System.out.println("----Navie Solution----");
	for(int i =0;i<arr.length-1;i++) {
		for(int j = i+1;j<arr.length;j++) {
			if(arr[i]>arr[j]) {
				return false;
			}
		}
	}
	
	return true;
}
}
