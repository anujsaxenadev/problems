package dynamic_programming;

public class CutIntoSegments {
    public static int cutSegments(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i] = -1;
        }
        // int result = cutSegmentsEval(n,x,y,z,dp);
        int result = cutSegmentsTab(n,x,y,z);
        if(result < 0){
            return 0;
        }
        else {
            return result;
        }
    }

    private static int cutSegmentsEval(int n, int x, int y, int z, int[] dp){
        if(n < 0){
            return Integer.MIN_VALUE;
        }
        else if(n == 0){
            return 0;
        }
        else if(dp[n] != -1){
            return dp[n];
        }
        else {
            int ansX = cutSegmentsEval(n - x, x, y, z, dp);
            int ansY = cutSegmentsEval(n - y, x, y, z, dp);
            int ansZ = cutSegmentsEval(n - z, x, y, z, dp);
            dp[n] = max(ansX, max(ansY, ansZ)) + 1;
            return dp[n];
        }
    }

    private static int cutSegmentsTab(int n, int x, int y, int z){
        if(n < 0){
            return Integer.MIN_VALUE;
        }
        else if(n == 0){
            return 0;
        }
        else {
            int[] dp = new int[n + 1];
            for(int i = 0; i < n + 1; i++){
                if(i == 0){
                    dp[i] = 0;
                }
                else {
                    dp[i] = -1;
                }
            }
            for(int i = 1; i < n + 1; i++){
                int ansX = -1;
                if(i - x >= 0){
                    ansX = dp[i - x];
                }
                int ansY = -1;
                if(i - y >= 0){
                    ansY = dp[i - y];
                }
                int ansZ = -1;
                if(i - z >= 0){
                    ansZ = dp[i - z];
                }
                int max = max(ansX, max(ansY, ansZ));
                if(max != -1){
                    dp[i] = max + 1;
                }
            }
            if(dp[n] != -1){
                return dp[n];
            }
            else {
                return 0;
            }
        }
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args){
        System.out.println(cutSegments(8,3,3,3));
    }
}
