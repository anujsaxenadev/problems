package dynamic_programming;

public class CutIntoSegments {
    public static int cutSegments(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i] = -1;
        }
        int result = cutSegmentsEval(n,x,y,z,dp);
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

    private static int max(int a, int b){
        return a > b ? a : b;
    }
    public static void main(String[] args){
        System.out.println(cutSegments(8,3,3,3));
    }
}
