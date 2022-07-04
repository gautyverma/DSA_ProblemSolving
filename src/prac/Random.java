package prac;

import java.util.ArrayList;
import java.util.List;

public class Random {
public static void main(String[] args) {
	int arr[] = {1,2,-3,4,-2,8};
	System.out.println(help(arr));
}

private static ArrayList<Integer> help(int arr[]) {
	// TODO Auto-generated method stub
	List<Integer> list = new ArrayList<>();
	
	for(int i =0;i<arr.length;i++) {
		list.add(arr[i]);
	}
	
 
	ArrayList<Integer> res = new ArrayList<>();
	for(int i = 0;i<arr.length;i++) {
		int temp = arr[i];
		if(!list.contains(-1*temp)) {
			res.add(-1*temp);
		}
	}
	return res;
	
}
}
