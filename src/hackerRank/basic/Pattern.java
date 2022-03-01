package hackerRank.basic;


public class Pattern {
	public static void main(String[] args) {
		int odd = 3;
		int even = 4;
		for (int i = 1; i < 5; i++) {
			int even1 = even;
			int odd1 = odd;
			int print = 0;
			boolean flag = true;
			
			for (int j = 1; j < 5; j++) {
				if (j == 1) {
					System.out.print(i + " ");
				} else if (i % 2 == 0 && j <= i) {
					if (flag) {
						print += i + odd1;
						flag = false;
					} else {
						print += odd1;
					}

					System.out.print(print + " ");
					odd += 2;
				} else if (i % 2 != 0 && j <= i) {
					if (flag) {
						print += i + even1;
						flag = false;
					} else {
						print += even1;
					}
					System.out.print(print + " ");
					even += 2;
				}
			}
			System.out.println();
		}
	}
}
