package InfyCodingEfficient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given an unsorted array find the count of swap to get pair max min pair as in sorted List
 * input - [4,1,2,9,3,6]
 * output - 2
*/
public class Bob_ArrayRearrange {
public static void main(String[] args) {
	Integer[] arr = {4,1,2,9,3,6};
	List<Integer> list = new ArrayList<>(Arrays.asList(arr));
	System.out.println(rearrange(list));
}

private static int rearrange(List<Integer> list) {
	int swapCount = 0;
	List<Integer> unsortedList = new ArrayList<Integer>();
	for (Integer ir : list) {
		unsortedList.add(ir);
	}
	Collections.sort(list);
	
	for(int i = 0;i<unsortedList.size();i += 2) {
		int firstElement = unsortedList.get(i);
		int firstElementIndex = list.indexOf(firstElement); // Index in sorted list
		int elementPair = list.get((-1-firstElementIndex)+unsortedList.size());
		int elementPairIndex = unsortedList.indexOf(elementPair);
		
		if(elementPair != list.get(i+1)) {
			//Swap
			int temp = unsortedList.get(elementPairIndex);
			unsortedList.set(elementPairIndex, unsortedList.get(i+1));
			unsortedList.set(i+1, temp);
			
			swapCount++;
		}
	}
	return swapCount;
}
}
