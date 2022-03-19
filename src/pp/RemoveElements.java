package pp;

import java.util.ArrayList;
import java.util.List;

public class RemoveElements {
public static void main(String[] args) {
	int[] arr = {1,2};
	System.out.println(removeElements(arr));
}

private static int removeElements(int[] arr) {
	// TODO Auto-generated method stub
	int count = 0;
	int value = 1;
	List<Integer> list = new ArrayList<>();
	for (int i = 0;i<arr.length ; i++) {
		if(arr[i]==value) {
			value++;
			list.add(arr[i]);
			continue;
		}else {
			count++;
		}
	}
	if(count>=arr.length)
		return -1;
	return count;
}
}
