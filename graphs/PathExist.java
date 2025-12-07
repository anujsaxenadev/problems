package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathExist {
    public boolean dcf(Map<Integer, ArrayList<Integer>> adjList, int source, int destination, int [] visitedArr){
        if(source == destination){
            return true;
        }
        visitedArr[source] = 1;
        for(int nextStep: adjList.get(source)){
            if(visitedArr[nextStep] == 0 && dcf(adjList, nextStep, destination, visitedArr)){
                return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
        for(int[] edge: edges){
            if(!adjList.containsKey(edge[0])){
                adjList.put(edge[0], new ArrayList<>());
            }
            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int [] visitedArr = new int[n];
        return dcf(adjList, source, destination, visitedArr);
    }
}
