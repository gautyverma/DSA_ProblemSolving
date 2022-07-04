package hackerRank.greedy;


import java.util.Scanner;

public class GoodLandElectricity {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int[] towers = new int[n];
	        for (int i = 0; i < n; i++) {
	            towers[i] = sc.nextInt();
	        }
	        int i = 0;
	        int maxTower = k-1;
	        int ans = 0;
	        while (true) {
	            int nextTower = -1;
	            while (i <= maxTower && i < n) {
	                if (towers[i] == 1) {
	                    nextTower = i;
	                }
	                i++;
	            }
	            if (nextTower == -1) {
	                System.out.println(-1);
	                return;
	            }
	            ans++;
	            i = nextTower + 1;
	            maxTower = nextTower+2*k-1;
	            if (nextTower+k>=n)
	                break;
	        }
	        System.out.println(ans);
	    }
	}
