package hackerRank.basic;

public class Test {
		

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
