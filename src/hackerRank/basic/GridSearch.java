package hackerRank.basic;

import java.util.Arrays;
import java.util.List;

public class GridSearch {
	public static void main(String[] args) {
		String[] gArr = { "7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374",
				"6473530293", "7053106601", "0834282956", "4607924137" };

		String[] pArr = { "9505", "3845", "3530" };
		List<String> g = Arrays.asList(gArr);
		List<String> p = Arrays.asList(pArr);
//		System.out.println(gridSearch(g, p));

		
		String[] gArr1 = { "34889246430321978567", "58957542800420926643", "35502505614464308821",
				"14858224623252492823", "72509980920257761017", "22842014894387119401", "01112950562348692493",
				"16417403478999610594", "79426411112116726706", "65175742483779283052", "89078730337964397201",
				"13765228547239925167", "26113704444636815161", "25993216162800952044", "88796416233981756034",
				"14416627212117283516", "15248825304941012863", "88460496662793369385", "59727291023618867708",
				"19755940017808628326" };

		String[] pArr1 = { "1641", "7942", "6517", "8907", "1376", "2691", "2599" };
		List<String> g1 = Arrays.asList(gArr1);
		List<String> p1 = Arrays.asList(pArr1);

		System.out.println(gridSearch(g1, p1));
	}

	private static String gridSearch(List<String> g, List<String> p) {
		int point = 0, sizeG = g.size(), sizeP = p.size();
		boolean flag = false;
		for (int i = 0; i < sizeG; i++) {
			if (g.get(i).contains(p.get(point))) {
				point++;
				for (int temp = i + 1; temp < i + sizeP; temp++) {
					if (g.get(temp).contains(p.get(point))) {
						String string = g.get(temp);
						String string2 = p.get(point);
						flag = true;
					} else {
						flag = false;
						break;
					}
					point++;
				}
				if (flag) {
					return "YES";
				} else {
					return "NO";
				}
			}
		}
		return null;
	}
}
