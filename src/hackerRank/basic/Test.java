package hackerRank.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		int[] arrDrone = {25,13,5};
		Integer[] arrWeight = {2,5,7,10,17};
		Arrays.sort(arrDrone);
		int[] arr2Drone = new int[2];
		
		arr2Drone[0] = arrDrone[arrDrone.length-1];
		arr2Drone[1] = arrDrone[arrDrone.length-2];
		
		Arrays.sort(arrWeight,Collections.reverseOrder());
		System.out.println(minWeight(arr2Drone,arrWeight));
	}

	/**
	 * @param arr2Drone
	 * @param arrWeight
	 * @return
	 */
	private static int minWeight(int[] arr2Drone, Integer[] arrWeight) {
		// TODO Auto-generated method stub
		int we = 0;
		for(int i = 0;i<arr2Drone.length;i++) {
			for(int j = 0 ;j<arrWeight.length;j++) {
				if(arrWeight[j]<arr2Drone[i]) {
					arr2Drone[i] -= arrWeight[j];
					arrWeight[j] = 0;
				}
			}
		}
		for(int i = 0;i<arrWeight.length;i++) {
			we += arrWeight[i];
		}
		return we;
	}
}
