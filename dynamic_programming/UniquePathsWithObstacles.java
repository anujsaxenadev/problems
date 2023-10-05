package dynamic_programming;

import java.util.HashMap;

public class UniquePathsWithObstacles {
    static HashMap<String, Integer> valueMap = new HashMap<>();
    public static void main(String[] args) {
        int[][] input = new int[2][2];
        input[0] = new int[]{0,0};
        input[1] = new int[]{0,0};
        System.out.println(uniquePathsWithObstacles(input));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0] == null){
            return 0;
        }
        else {
            return checkUniquePathsMem(obstacleGrid, 0, 0, obstacleGrid[0].length, obstacleGrid.length);
        }
    }

    public static int checkUniquePathsMem(int[][] obstacleGrid, int x, int y, int xLength, int yLength){
        if(x == xLength - 1 && y == yLength - 1 && obstacleGrid[y][x] != 1){
            return 1;
        }
        else if(obstacleGrid[y][x] == 1){
            return 0;
        }
        else if(valueMap.containsKey(x + "," + y)){
            return valueMap.get(x + "," + y);
        }
        else {
            int bottomResult = 0;
            if(x + 1 < xLength){
                bottomResult = checkUniquePathsMem(obstacleGrid, x + 1, y, xLength, yLength);
                valueMap.put((x + 1) + "," + y, bottomResult);
            }
            int rightResult = 0;
            if(y + 1 < yLength){
                rightResult = checkUniquePathsMem(obstacleGrid, x, y + 1, xLength, yLength);
                valueMap.put(x + "," + (y + 1), rightResult);
            }
            return rightResult + bottomResult;
        }
    }

    public static int checkUniquePathsRecursively(int[][] obstacleGrid, int x, int y, int xLength, int yLength){
        if(x == xLength - 1 && y == yLength - 1 && obstacleGrid[y][x] != 1){
            return 1;
        }
        else if(obstacleGrid[y][x] == 1){
            return 0;
        }
        else {
            int bottomResult = 0;
            if(x + 1 < xLength){
                bottomResult = checkUniquePathsRecursively(obstacleGrid, x + 1, y, xLength, yLength);
            }
            int rightResult = 0;
            if(y + 1 < yLength){
                rightResult = checkUniquePathsRecursively(obstacleGrid, x, y + 1, xLength, yLength);
            }
            return rightResult + bottomResult;
        }
    }
}
