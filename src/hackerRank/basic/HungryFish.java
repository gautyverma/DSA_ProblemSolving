package hackerRank.basic;

import java.util.Arrays;

public class HungryFish {
	public static void main(String[] args) {
		int[] fish1 = { 9, 20, 25, 100 };
		int[] fish2 = { 25, 20, 100, 400, 500 };
		int[] fish3 = { 25, 20, 9, 100 };

		System.out.println(hungryFish(10, fish1));
		System.out.println(hungryFish(3, fish2));
		System.out.println(hungryFish(50, fish3));
	}

	public static int hungryFish(int infectedFishSize, int[] fishs) {
		Arrays.sort(fishs);
		int moves = 0;

		for (int i = 0; i < fishs.length; i++) {
			if (fishs[i] < infectedFishSize) {
				infectedFishSize += fishs[i];
			} else {
				if (fishs[i] < (infectedFishSize + infectedFishSize - 1)) {
					infectedFishSize += (infectedFishSize - 1);
					moves++;
				} else {
					moves += (fishs.length - i);
					break;
				}
			}
		}

		return moves;
	}
}
