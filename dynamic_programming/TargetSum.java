package dynamic_programming;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
        }
        if((sum - target) % 2 != 0 || target > sum){
            return 0;
        }
        else {
            return countSubsetSum(nums, (sum - target) / 2);
        }
    }

    public static int countSubsetSum(int[] nums, int sum){
        int[][] dp = new int[nums.length + 1] [sum + 1];
        for(int j = 0; j < sum + 1; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i < nums.length + 1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < nums.length + 1; i++){
            for(int j = 0; j < sum + 1; j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length] [sum];
    }
    public static void main(String[] args){
        System.out.println(findTargetSumWays(new int[]{0,0,1}, 1));
    }
}
