package hackerRank.basic;

import java.util.ArrayList;
import java.util.List;

public class IceCreamParlor {
public static void main(String[] args) {
//	Integer[] costArr = {1,3,4,4,6,8};
//	List<Integer> cost = Arrays.asList(costArr);
//	System.out.println(foo(8,cost));
	int mask = 0x000F;
	int value = 0x2222;
	System.out.println(value&mask);
}

private static List<Integer> foo(int m, List<Integer> arr) {
	// TODO Auto-generated method stub
	List<Integer> list = new ArrayList<Integer>();
	for(int i =0;i<arr.size();i++) {
		for(int j=1;j<arr.size();j++) {
			if(arr.get(i)+arr.get(j)==m) {
				if(arr.get(i)==arr.get(j)) {
					list.add(i+1);
					list.add(i+1);
					return list;
				}
				list.add(i+1);
				list.add(j+1);
				return list;
			}
		}
	}
	return list;
}
}
