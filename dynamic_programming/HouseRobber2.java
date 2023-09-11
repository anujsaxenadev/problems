package dynamic_programming;

public class HouseRobber2 {
    public static int findMaxRob(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        else if (length == 1){
            return nums[0];
        }
        else {
            int[] dp = new int[length];
            dp[0] = nums[0];
            for(int i = 1; i < length; i++){
                dp[i] = max(dp[i - 1], (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i]);
            }
            return dp[length - 1];
        }
    }

    public static int rob(int[] nums){
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        else if (length == 1){
            return nums[0];
        }
        else {
            int[] num1 = new int[length - 1];
            int[] num2 = new int[length - 1];
            for(int i = 0; i < length; i++){
                if(i > 0){
                    num1[i - 1] = nums[i];
                }
                if(i < length - 1){
                    num2[i] = nums[i];
                }
            }
            return max(findMaxRob(num1), findMaxRob(num2));
        }
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args){
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
