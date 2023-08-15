package dynamic_programming;

public class CountTheSubsetsWithGivenSum {

    int countSubsets(int[] arr, int sum){
        if(sum == 0){
            return 1;
        }
        else if(arr.length == 0){
            return 0;
        }

        int[][] dp = new int[arr.length + 1][sum + 1];
        for(int i = 0; i < arr.length + 1; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < sum + 1; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i < arr.length + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
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
