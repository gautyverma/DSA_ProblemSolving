package InfyCodingEfficient;

import java.util.*;

public class A7_MinSweetsMaxHappy {
	private static int yMax = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer[]> list= new ArrayList<Integer[]>();
		
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			Integer[] temp = new Integer[2];
			
			arr[i][0] = sc.nextInt();
			int y = sc.nextInt();
			arr[i][1] = y;

			if (y > yMax) {
				yMax = y;
			}
		
			
			temp[0] = arr[i][0];
			temp[1] = y;
			list.add(temp);
		}
//		countMinHappy(arr);
//		System.out.println(Arrays.toString(list.toArray()));
		printResult(list, n);
		
		
	}

	private static void countMinHappy(int[][] arr) {
		// TODO Auto-generated method stub
		int[] res = new int[2];

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i < yMax; i++) {
			int countStudents = 0; // Max
			int countSweets = 0; // Min
			for (int index = 0; index < arr.length; index++) {
				if (i < arr[index][1] && i >= arr[index][0]) {
					countStudents++;
					countSweets = i;
				}
			}
			map.put(countSweets, countStudents);
		}
		int max = 0;
		Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, Integer> entry = itr.next();
			if (entry.getValue() > max) {
				max = entry.getValue();
				res[0] = entry.getKey();
				res[1] = entry.getValue();
			}
		}
		System.out.println(res[0] + " " + res[1]);
	}
	
//	boolean add(E element): This method inserts the specified element into this priority queue.
//	public peek(): This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
//	public poll(): This method retrieves and removes the head of this queue, or returns null if this queue is empty.

	private static void printResult(ArrayList<Integer[]> list, int n) {
		list.sort(Comparator.comparingInt((Integer[] o) -> o[0]).thenComparingInt(o -> o[1]));
		int maxStudents = 0;
		int minChocolates = 0;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (Integer[] integers : list) {
			priorityQueue.add(integers[1]);
			while (priorityQueue.size() > 0 && integers[0] > priorityQueue.peek()) {
				priorityQueue.poll();
			}
			if (maxStudents < priorityQueue.size()) {
				minChocolates = integers[0];
				maxStudents = priorityQueue.size();
			}
		}
		System.out.println(minChocolates + " " + maxStudents);
	}
}
