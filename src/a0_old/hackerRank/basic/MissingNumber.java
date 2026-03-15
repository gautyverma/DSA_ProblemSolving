//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//
//
//public class MissingNumber {
//
//	public static List<Integer> missingNumbers(List<Integer> arr,List<Integer> brr){
//		
//		
//		
//		HashSet<Integer>missing = new HashSet<>();
//		for(Integer b:brr) {
//			if(arr.contains(b)) {
//
//				System.out.println("======="+b);
//				arr.remove(Integer.valueOf(b));
//			}
//			else {
//				missing.add(b);
//			}
//		}
//		
//		List<Integer> res = new ArrayList<Integer>(missing);
//		Collections.sort(res);
//		return res;
//	}
//		
//	public static void main(String[] args) {
//		Integer[] arr1= {3,4,5,6,7,3,4,5,6};
//		List<Integer> arr =new ArrayList<>(Arrays.asList(arr1));
//		
////		for(int i:arr1) {
////			arr.add(i);
////		}
//		
//		Integer[] brr1= {3,4,5,6,7,5,8,3,4,6,5,6,4};
////		List<Integer> brr = Arrays.asList(brr1);
//		List<Integer> brr =new ArrayList<>(Arrays.asList(brr1));
////		for(int i:brr1) {
////			brr.add(i);
////		}
//		
//		List<Integer> res = missingNumbers(arr, brr);
//		System.out.println(res);
//		
//	}
//}
