package prac;

public class ModuloGame {
	private static int mod = 109+7;
public static void main(String[] args) {
	String str = "??33?";
	System.out.println(helpful(str));
	
}

private static int helpful(String s) {
	// TODO Auto-generated method stub
	int n = s.length();
	long [][]dp= new long[n+1][143];
	dp[0][0] = 1;
	for(int i =0;i<n;i++) {
		for(int j = 0;j<10;j++) {
			int nxt = s.charAt(i) - '0';
			if(s.charAt(i)=='?')
				nxt = j;
			
			for(int k = 0;k<143;k++) {
				int rem = (10*k+nxt)%143;
				dp[i+1][rem] += dp[i][k];
				dp[i+1][rem] %= mod;
			}
			if(s.charAt(i) != '?')
				break;
		}
	}
	
	return (int)dp[n][7];
}
}
