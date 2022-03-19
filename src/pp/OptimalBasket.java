package pp;

public class OptimalBasket {
	public static void main(String[] args) {
		int apple = 4;
		int mango = 5;
		System.out.println(countVal(apple, mango));
	}

	private static int countVal(int apple, int mango) {
		// TODO Auto-generated method stub
		if (apple == 1 && mango == 1) {
			return 0;
		}
		int count = 0;
		int max = Math.max(mango, apple);
		int min = Math.min(mango, apple);
		while (max > 0 && min > 0) {
			max -= 2;
			min -= 1;
			count++;

			if (min > max) {
				max = max + min;
				min = max - min;
				max = max - min;
			}

		}
		return count;
	}
}
