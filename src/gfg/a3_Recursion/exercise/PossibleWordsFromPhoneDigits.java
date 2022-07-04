package gfg.a3_Recursion.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PossibleWordsFromPhoneDigits {

	static Character[][] numberToCharMap;

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4 };
		System.out.println("-- GFG Approach --");
		printWords(arr);
	}



	private static void printWords(int[] numbers) {
		// TODO Auto-generated method stub
		generateNumberToCharMap();
		List<String> stringList = printWords(numbers, numbers.length, 0, "");
		stringList.stream().forEach(System.out::println);
	}

	private static void generateNumberToCharMap() {
		// TODO Auto-generated method stub
		numberToCharMap = new Character[10][5];
		numberToCharMap[0] = new Character[] { '\0' };
		numberToCharMap[1] = new Character[] { '\0' };
		numberToCharMap[2] = new Character[] { 'a', 'b', 'c' };
		numberToCharMap[3] = new Character[] { 'd', 'e', 'f' };
		numberToCharMap[4] = new Character[] { 'g', 'h', 'i' };
		numberToCharMap[5] = new Character[] { 'j', 'k', 'l' };
		numberToCharMap[6] = new Character[] { 'm', 'n', 'o' };
		numberToCharMap[7] = new Character[] { 'p', 'q', 'r', 's' };
		numberToCharMap[8] = new Character[] { 't', 'u', 'v' };
		numberToCharMap[9] = new Character[] { 'w', 'x', 'y', 'z' };
	}

	private static List<String> printWords(int[] numbers, int len, int index, String str) {
		// TODO Auto-generated method stub
		if (len == index) {
			return new ArrayList<>(Collections.singleton(str));
		}
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < numberToCharMap[numbers[index]].length; i++) {
			String sCopy = String.copyValueOf(str.toCharArray());
			sCopy = sCopy.concat(numberToCharMap[numbers[index]][i].toString());
			stringList.addAll(printWords(numbers, len, index + 1, sCopy));
		}
		return stringList;

	}

}
