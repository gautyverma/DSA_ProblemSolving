package gfg.a19_BackTracking.exercise;

public class a5_BlackNWhite {
    public static void main(String[] args){
    System.out.println(numOfWays(2,2));
    }

    static final long MOD = 1000000007;

    public static long numOfWays(int N, int M) {

        long total = (long) N * M % MOD;

        long totalWays = (total * ((total - 1 + MOD) % MOD)) % MOD;

        long attackPairs = 0;

        if (N >= 2 && M >= 3)
            attackPairs = (attackPairs + (long)(N - 1) * (M - 2) % MOD) % MOD;

        if (N >= 3 && M >= 2)
            attackPairs = (attackPairs + (long)(N - 2) * (M - 1) % MOD) % MOD;

        attackPairs = (2 * attackPairs) % MOD;   // unordered
        attackPairs = (2 * attackPairs) % MOD;   // ordered

        long ans = (totalWays - attackPairs + MOD) % MOD;

        return ans;
    }
}
