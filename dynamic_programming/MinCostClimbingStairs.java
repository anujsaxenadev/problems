package dynamic_programming;

public class MinCostClimbingStairs {
    int[] minCostAtI = null;
    public int minCostClimbingStairs(int[] cost) {
        minCostAtI = new int[cost.length];
        for(int i = 0; i < minCostAtI.length; i++){
            minCostAtI[i] = -1;
        }
        int cost1 = cost[0] + getMinCostClimbingStairs(cost, 0);
        int cost2 = cost[1] + getMinCostClimbingStairs(cost, 1);
        return Math.min(cost1, cost2);
    }

    public int getMinCostClimbingStairs(int[] cost, int index) {
        if(index < cost.length && minCostAtI[index] != -1){
            return minCostAtI[index];
        }
        int cost1 = 0;
        if(index + 1 < cost.length){
            cost1 = cost[index + 1] + getMinCostClimbingStairs(cost, index + 1);
        }
        int cost2 = 0;
        if(index + 2 < cost.length){
            cost2 = cost[index + 2] + getMinCostClimbingStairs(cost, index + 2);
        }
        minCostAtI[index] = Math.min(cost1, cost2);
        return minCostAtI[index];
    }
}
