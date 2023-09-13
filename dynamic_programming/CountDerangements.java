package dynamic_programming;

public class CountDerangements {
    final static int MOD = 1000000007;
    public static long countDerangements(int n) {
        if(n == 0 || n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        else {
            return (((n - 1) % MOD) * ((countDerangements(n - 2) % MOD + countDerangements(n - 1) % MOD) % MOD)) % MOD;
        }
	}

    public static long countDerangementsMem(int n, long[] dp) {
        if(n == 0 || n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        else if(dp[n] != -1){
            return dp[n];
        }
        else {
            dp[n] = (((n - 1) % MOD) * ((countDerangementsMem(n - 2, dp) % MOD + countDerangementsMem(n - 1, dp) % MOD) % MOD)) % MOD;
            return dp[n];
        }
	}

    public static long countDerangementsTab(int n) {
        if(n == 0 || n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        else {
            long[] dp = new long[n + 1];
            for(int i = 0; i < n + 1; i++){
                dp[i] = -1;
            }
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            for(int i = 3; i <= n; i++){
                dp[i] = (((i - 1) % MOD) * ((dp[i - 2] % MOD) + (dp[i - 1] % MOD)) % MOD) % MOD;
            }
            return dp[n];
        }
	}

    public static long countDerangementsTabSpace(int n) {
        if(n == 0 || n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        else {
            long prev2 = 0, prev1 = 1;
            for(int i = 3; i <= n; i++){
                long current = (((i - 1) % MOD) * ((prev2 % MOD) + (prev1 % MOD)) % MOD) % MOD;
                prev2 = prev1;
                prev1 = current;
            }
            return prev1;
        }
	}

    public static void main(String[] args){
        int n = 2078;
        long[] dp = new long[n + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i] = -1;
        }
        System.out.println(countDerangementsTabSpace(n));
    }
}
