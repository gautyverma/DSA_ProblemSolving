package gfg.a3_Recursion.exercise;

public class TowerOfHanoi {
	public static void main(String[] args) {
		int n = 2; // number of disks
		System.out.println(toh(n, 1, 3, 2));
	}

	private static long toh(int n, int from, int to, int aux) {
		// TODO Auto-generated method stub
		long count = 0;
		if (n == 0) {
			return 0;
		}
		count += toh(n - 1, from, aux,to);
		System.out.println("move disk " + n + " from rod " + from + " to rod " +to);
		count += toh(n - 1, aux, to, from);
		return ++count;
	}
}
