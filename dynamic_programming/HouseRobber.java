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

    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args){
        System.out.println(maxRobRec(new int[]{1,2,3}, 0, 0));
    }
    
}
