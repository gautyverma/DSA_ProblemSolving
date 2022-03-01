package hackerRank.greedy;

import java.util.Scanner;

public class BeautifulPair {
    
    private static final int MAX_NUM = 1000;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int [] bucketA = new int[MAX_NUM + 1];
        for (int i = 0; i < N; i++) {
            bucketA[scan.nextInt()]++;
        }
        int beautifulPairs = 0;
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            if (bucketA[num] > 0) {
                bucketA[num]--;
                beautifulPairs++;
            }
        }
        scan.close();
        
        /* Accounts for changing 1 element in B */
        if (beautifulPairs == N) {
            beautifulPairs--;
        } else {
            beautifulPairs++;
        }
        System.out.println(beautifulPairs);
    }
}