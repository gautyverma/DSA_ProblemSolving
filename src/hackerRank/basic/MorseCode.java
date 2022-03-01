package hackerRank.basic;
import java.util.HashMap;

public class MorseCode {

	static String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z" };
	static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	public static void main(String[] args) {
		HashMap<Character, String> map = new HashMap<>();
		map.put('a', ".-");
		map.put('b', "-...");
		map.put('c', "-.-.");
		map.put('d', "-..");
		map.put('e', ".");
		map.put('f', "..-.");
		map.put('g', "--.");
		map.put('h', "....");
		map.put('i', "..");
		map.put('j', ".---");
		map.put('k', "-.-");
		map.put('l', ".-..");
		map.put('m', "--");
		map.put('n', "-.");
		map.put('o', "---");
		map.put('p', ".--.");
		map.put('q', "--.-");
		map.put('r', ".-.");
		map.put('s', "...");
		map.put('t', "-");
		map.put('u', "..-");
		map.put('v', "...-");
		map.put('w', ".--");
		map.put('x', "-..-");
		map.put('y', "-.--");
		map.put('z', "--..");

		String str1 = "Eta".toLowerCase();
		StringBuilder morseString = new StringBuilder();
		for (int i = 0; i < str1.length(); i++) {
			morseString.append(map.get(str1.charAt(i)));
		}
		System.out.println(countPossibleWord(morseString.toString(),"",str1.length()));
	}
	public static int countPossibleWord(String strMorse, String strAlpha, int inputSize) {
	    if (strMorse.length() > 0) {  // still input to process
	        if (strAlpha.length() >= inputSize)
	            return 0; // String already has wrong size
	        int count = 0;
	        for (int i = 0; i < morse.length; i++) { // try all morse codes
	        	String morseValue = morse[i];
	        	
	            if (strMorse.startsWith(morse[i])) { // on the beginning of the given string
	            	
	            	String substring = strMorse.substring(morse[i].length()); // leaves the first morse[i].length and till end of string
	            	String concat = strAlpha+alpha[i];
	            	
	                count += countPossibleWord(strMorse.substring(morse[i].length()), strAlpha+alpha[i], inputSize);
	            }
	        }
	        return count;
	    } else {
	        if( strAlpha.length() == inputSize ) {
//	            System.out.println( strAlpha );
	            return 1; // one solution has been found
	        } else {
	            return 0; // String has wrong size
	        }
	    }
	}
}
