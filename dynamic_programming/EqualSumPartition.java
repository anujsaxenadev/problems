package dynamic_programming;

public class EqualSumPartition {


    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 0){
            int targetSum = sum / 2;
            boolean[][] dp = new boolean[length + 1][targetSum + 1];
            for(int j = 0; j < targetSum + 1; j++){
                dp[0][j] = false;
            }
            for(int i = 0; i < length + 1; i++){
                dp[i][0] = true;
            }
            for(int i = 1; i < length + 1; i++){
                for(int j = 1; j < targetSum + 1; j++){
                    if(nums[i - 1] <= j){
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[length][targetSum];
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){

    }
}
