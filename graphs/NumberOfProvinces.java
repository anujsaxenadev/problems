package graphs;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
    A province is a group of directly or indirectly connected cities and no other cities outside of the group.
    You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
    Return the total number of provinces.
 */
public class NumberOfProvinces {
    private void dcf(int start, int[][] isConnected, int[] visitedArr){
        if(visitedArr[start] == 1){
            return;
        }
        visitedArr[start] = 1;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[start][i] == 1 && start != i){
                dcf(i, isConnected, visitedArr);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int numberOfProvinces = 0;
        int n = isConnected.length;
        int[] visitedArr = new int[n];

        for(int i = 0; i < n; i++){
            if(visitedArr[i] == 0){
                numberOfProvinces++;
                dcf(i, isConnected, visitedArr);
            }
        }

        return numberOfProvinces;
    }
}
