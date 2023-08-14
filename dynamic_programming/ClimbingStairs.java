package dynamic_programming;

public class ClimbingStairs {
    static int[] dp = null;

    public static int climbStairs(int n) {
        dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i] = -1;
        }
        getNumberOfStepsToClimbStairs(n, 0);
        return dp[0] + 1;
    }

    public static int getNumberOfStepsToClimbStairs(int n, int index){
        if(index >= 0 && index < n + 1 && dp[index] != -1){
            return dp[index];
        }
        int steps1 = 0;
        if(index + 1 < n + 1){
            steps1 = getNumberOfStepsToClimbStairs(n, index + 1);
        }
        int steps2 = 0;
        if(index + 2 < n + 1){
            steps2 = getNumberOfStepsToClimbStairs(n, index + 2) + 1;
        }
        dp[index] = steps1 + steps2;
        return dp[index];
    }

    public static void main(String[] args){
        System.out.println(climbStairs(3));
    }
}
