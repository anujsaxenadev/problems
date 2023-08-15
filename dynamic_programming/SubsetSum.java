package dynamic_programming;

public class SubsetSum {

    static boolean findSubsetSum(int[] arr, int sum){
        if(sum == 0){
            return true;
        }
        else if(arr.length == 0){
            return false;
        }
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for(int j = 0; j < sum + 1; j++){
            dp[0][j] = false;
        }
        for(int i = 0; i < arr.length + 1; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i < arr.length + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(arr[i - 1] <= sum){
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args){

    }
    
}
