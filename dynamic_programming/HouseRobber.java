package dynamic_programming;

import java.util.HashMap;

public class HouseRobber {
    public static HashMap<Integer, Integer> valueMap = new HashMap<>();
    public static int maxRobRec(int[] nums, int i, int sum) {
        if(i >= nums.length){
            return sum;
        }
        else if(valueMap.containsKey(i)){
            return valueMap.get(i) + sum;
        }
        else {
            int max = max(maxRobRec(nums, i + 1, sum), maxRobRec(nums, i + 2, sum + nums[i]));
            valueMap.put(i, max);
            return max;
        }
    }

    public static int maxRobTab(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        else if(length == 1){
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

    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args){
        System.out.println(maxRobTab(new int[]{1,2,3}));
    }
    
}
