package dynamic_programming;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] input = new int[1][2];
        input[0] = new int[]{0,0};
        System.out.println(uniquePathsWithObstacles(input));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0] == null){
            return 0;
        }
        else {
            return checkUniquePathsRecursively(obstacleGrid, 0, 0, obstacleGrid[0].length, obstacleGrid.length);
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
