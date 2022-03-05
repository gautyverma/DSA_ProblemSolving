package hackerRank.basic;

import java.util.LinkedList;
import java.util.Scanner;

public class LarrysArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int n = sc.nextInt();
//			String[] sp = sc.nextLine().split("\\s+");
			LinkedList<Integer> ll = new LinkedList<>();
			for (int j = 0; j < n; j++) {
				ll.add(sc.nextInt());
			}
			
			for(int j = 0;j<n-2;j++) {
				if(ll.get(j) != j+1) {
					int index = findIndex(ll,j+1);
					if((index-j)%2==0) {
						int val = ll.remove(index);
						ll.add(j, val);
					}else {
						int val = ll.remove(index);
						ll.add(j, val);
						int temp = ll.remove(j+2);
						ll.add(j+1,temp);
					}
				}
			}
			String res = "YES";
			if(ll.get(n-1) != n)
				res = "NO";
			System.out.println(res);
		}
	}

	private static int findIndex(LinkedList<Integer> ll, int i) {
		// TODO Auto-generated method stub
		for(int x = i;x<ll.size();x++) {
			if(ll.get(x)== i)
				return x;
		}
		return -1;
	}
}
