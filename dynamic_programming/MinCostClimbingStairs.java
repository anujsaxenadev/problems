package dynamic_programming;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if(length == 1){
            return cost[0];
        }
        else if(length == 1){
            return min(cost[0], cost[1]);
        }
        else {
            int prev1 = cost[0], prev2 = cost[1];
            for(int i = 2; i < length + 1; i++){
                int temp = prev2;
                prev2 = min(prev2, prev1) + ((i == length) ? 0  : cost[i]);
                prev1 = temp;
            }
            return prev2;
        }
    }

    private static int min(int a, int b){
        return (a > b) ? b : a;
    }

    public static void main(String[] args){
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
}
