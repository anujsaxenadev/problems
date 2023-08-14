package dynamic_programming;

public class MaximumGeneratedArray {

    public static int getMaximumGenerated(int n) {
        int[] dp = new int[n + 1];
        int max = -1;
        for(int i = 0; i < n + 1; i++){
            if(i == 0){
                dp[i] = 0;
            }
            else if(i == 1){
                dp[1] = 1;
            }
            else if(i % 2 == 0){
                dp[i] = dp[i / 2];
            }
            else {
                dp[i] = dp[(i - 1) / 2] + dp[(i + 1) / 2];
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args){
        System.out.println(getMaximumGenerated(7));
    }
}
