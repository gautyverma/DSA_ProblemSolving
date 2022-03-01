package hackerRank.Growth2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Growth2D {
	public static void main(String[] args) {
		String[] arr = { "1 4", "2 3", "4 1" };
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		int count = maxCount(list);
		System.out.println(count);
	}

	private static int maxCount(List<String> list) {
		List<Integer> intList = new ArrayList<Integer>();
		int max = 0,maxCount=0;
		Object[] arr = list.toArray();

		for (Object obj : arr) {
			String[] split = obj.toString().split(" ");
			Integer var1 = Integer.parseInt(split[0]);
			Integer var2 = Integer.parseInt(split[1]);
			intList.add(var1);
			intList.add(var2);
			if (var1 >= max) {
				max = var1;
			} else {
				max = var2;
			}
		}
		
		int[][] grid = new int[max][max];
		
		for(int i=0;i<intList.size();i=i+2) {
			int var1 =intList.get(i);
			int var2 = intList.get(i+1);
			for(int j=0;j<var1;j++) {
				for(int k=0;k<var2;k++) {
					grid[j][k] += 1;
					if(grid[j][k]>maxCount) {
						maxCount = grid[j][k];
					}
				}
			}
		}
		

		return maxCount;

	}
}
