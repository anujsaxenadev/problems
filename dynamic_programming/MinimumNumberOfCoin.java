package dynamic_programming;

import java.util.HashMap;

public class MinimumNumberOfCoin {
    static HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
    static public int coinChangeTab(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if((i - coins[j] >= 0) && (dp[i - coins[j]] != Integer.MAX_VALUE)){
                    dp[i] = min(dp[i], 1 + dp[i - coins[j]]);  
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        else {
            return dp[amount];
        }
    }

    static public int coinChangeRec(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        else if(amount < 0){
            return Integer.MAX_VALUE;
        }
        else if(valueMap.containsKey(amount)){
            return valueMap.get(amount);
        }
        else {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++){
                int minCoinsFromIth = coinChangeRec(coins, amount - coins[i]);
                if(minCoinsFromIth != Integer.MAX_VALUE){
                    min = min(minCoinsFromIth + 1, min);
                }
            }
            valueMap.put(amount, min);
            return min;
        }
    }

    static private int min(int a, int b){
        return a > b ? b : a;
    }

    public static void main(String[] args){
        System.out.println(coinChangeTab(new int[]{1,2,5}, 11));
    }
}
