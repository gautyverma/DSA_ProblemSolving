package hackerRank.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GirdChallenge {
	public static void main(String[] args) {
		String[] gird = {"ebacd", "fghij", "olmkn", "trpqs", "xywuv"};
		
		String[] gird1 = {"abc", "lmp", "qrt"};
		String[] gird2 = {"mpxz","abcd","wlmf"};
		String[] gird3 = {"abc", "hjk", "mpq","rtv"};
		
		
//		System.out.println( gridChallenge(Arrays.asList(gird)));
//		System.out.println( gridChallenge(Arrays.asList(gird1)));
//		System.out.println( gridChallenge(Arrays.asList(gird2)));
		System.out.println( gridChallenge(Arrays.asList(gird3)));
		
	}

	private static String gridChallenge(List<String> grid) {
		int n = grid.size();
		char[][] arr = new char[n][grid.get(0).length()];
		int row = 0;
		String res="YES";
		for (String obj : grid) {
			int col = 0;
			String sortString = sortString(obj);
			char[] charArray = sortString.toCharArray();
			for (char cs : charArray) {
				arr[row][col] = cs;
				col++;
			}
			row++;
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<grid.get(0).length();j++) {
				if(arr[i][j]>arr[i+1][j]) {
					res = "NO";
					break;
				}
			}
		}
		return res;
	}
	
	private static String sortString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return(new String(charArray));
	}
	
	
}
