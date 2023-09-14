package dynamic_programming;

public class NinjaAndFence {
    private static int MOD = 1000000007;
    private static int numberOfWays(int n, int k) {
        // return findNumberOfWaysRec(n, k);
        // int[] dp = new int[n + 1];
        // for(int i = 0; i < n + 1; i++){
        //     dp[i] = -1;
        // }
        // return findNumberOfWaysMem(n, k, dp);
        return findNumberOfWaysTab(n, k);
    }

    private static int add(int a, int b){
        return (a % MOD + b % MOD) % MOD;
    }

    private static int mul(int a, int b){
        return (int)(((a % MOD) * 1L * (b % MOD)) % MOD);
    }
    

     private static int findNumberOfWaysRec(int n, int k){
        if(n == 1){
            return k;
        }
        else if(n == 2){
            return mul(k, k);
        }
        return add(mul(k - 1, findNumberOfWaysRec(n - 1, k)), mul(k - 1, findNumberOfWaysRec(n - 2, k)));
    }

    private static int findNumberOfWaysMem(int n, int k, int[] dp){
        if(n == 1){
            return k;
        }
        else if(n == 2){
            return mul(k, k);
        }
        else if(dp[n] != -1){
            return dp[n];
        }
        else{
            dp[n] = add(mul(k - 1, findNumberOfWaysMem(n - 1, k, dp)), mul(k - 1, findNumberOfWaysMem(n - 2, k, dp)));
            return dp[n];
        }
    }

    private static int findNumberOfWaysTab(int n, int k){
        if(n == 1){
            return k;
        }
        else if(n == 2){
            return mul(k, k);
        }
        else{
            int prev2 = k;
            int prev1 = mul(k, k);
            for(int i = 3; i < n + 1; i++){
                int temp = add(mul(k - 1, prev1), mul(k - 1, prev2));
                prev2 = prev1;
                prev1 = temp;
            }
            return prev1;
        }
    }

    public static void main(String[] args){
        System.out.println((numberOfWays(74,23)));
    }
}
